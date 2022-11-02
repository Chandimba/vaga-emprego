
CREATE DATABASE IF NOT EXISTS vaga_emprego;

USE  vaga_emprego;

CREATE TABLE IF NOT EXISTS profissao (
	id binary(36) not null primary key,
    designacao varchar(150) not null,
	constraint uk_profissao_descricao unique(designacao)
);

CREATE TABLE IF NOT EXISTS candidato (
	id binary(36) not null primary key,
    nome varchar(100) not null,
    email varchar(250) not null,
    data_nascimento date not null,
    profissao_id binary(36) not null,
    nacionalidade varchar(75) not null,
    cidade varchar(75) not null,
    morada varchar(250) not null,
    data_registo date
);

CREATE TABLE IF NOT EXISTS telefone (
	candidato_id binary(36)  not null ,
    numero varchar(25) not null,
    constraint uk_telefone UNIQUE(numero),
	constraint fk_telefone_candidato foreign key(candidato_id) references candidato(id)
);

CREATE TABLE IF NOT EXISTS conta (
	email varchar(250) not null primary key,
	senha varchar(250) not null,
    perfil binary(1) default 0
);

CREATE TABLE IF NOT EXISTS curso (
	id binary(36) not null primary key,
	designacao varchar(100) not null,
    constraint uk_curso unique(designacao)
);

CREATE TABLE IF NOT EXISTS curso_candidato (
	curso_id binary(36) not null,
	candidato_id binary(36)  not null,
    data_inicio date,
    data_fim date,
    constraint pk_cursocandidato primary key(curso_id, candidato_id),
    constraint fk_cursocandidato_curso foreign key(curso_id) references curso(id),
    constraint fk_cursocandidato_candidato foreign key(candidato_id) references candidato(id)
);

CREATE TABLE IF NOT EXISTS formacao_academica (
	id binary(36) not null primary key,
    curso varchar(150) not null,
    grau_academico varchar(15) not null,
    instituicao varchar(100) not null,
	data_inicio date,
    data_fim date,
    candidato_id binary(36) not null,
    constraint fk_formacao_academica foreign key(candidato_id) references candidato(id)
);

CREATE TABLE IF NOT EXISTS experiencia_trabalho (
	id binary(36)  not null primary key,
    cargo varchar(36) not null,
    empresa varchar(36) not null,
	data_inicio date,
    data_fim date,
    candidato_id binary(36) not null,
    constraint fk_experiencia_trabalho foreign key(candidato_id) references candidato(id)
);

CREATE TABLE IF NOT EXISTS lingua (
	id binary(36)  not null primary key,
	designacao varchar(100) not null,
    constraint uk_lingua unique(designacao)
);

CREATE TABLE IF NOT EXISTS lingua_candidato (
	lingua_id binary(36) not null,
	candidato_id binary(36) not null,
    nivel int(1) comment '0-Native; 1-Fluent; 2-Beginner; 3-Elementary; 4-Pre-Intermediate; 5-Itermediate; 6-Advanced; 7-Good',
    constraint pk_linguacandidato primary key(lingua_id, candidato_id),
    constraint fk_linguacandidato_lingua foreign key(lingua_id) references lingua(id),
    constraint fk_linguacandidato_candidato foreign key(candidato_id) references candidato(id)
);

CREATE TABLE IF NOT EXISTS referencia (
	id binary(36) not null primary key,
    nome varchar(100) not null,
    email varchar(250) not null,
	telefone varchar(25) not null,
    cargo varchar(50) not null,
    relacao varchar(50) not null,
    candidato_id binary(36) not null,
    constraint fk_referencia foreign key(candidato_id) references candidato(id)
);

CREATE TABLE IF NOT EXISTS curriculo (
	id binary(36) not null primary key,
	objectivo longtext,
    foto longtext not null,
    data_registo date,
    candidato_id binary(36) not null,
    constraint fk_curriculo_candidato foreign key(candidato_id) references candidato(id)
);

CREATE TABLE IF NOT EXISTS curriculo_formacademica (
	curriculo_id binary(36) not null,
    formacaoacademica_id binary(36)  not null,
    constraint pk_curriculoformacademica primary key (curriculo_id, formacaoacademica_id),
    constraint fk_curriculoformacademica_curriculo foreign key(curriculo_id) references curriculo(id),
    constraint fk_curriculoformacademica_lingua foreign key(formacaoacademica_id) references formacao_academica(id)
);

CREATE TABLE IF NOT EXISTS curriculo_lingua (
	curriculo_id binary(36) not null,
    lingua_id binary(36) not null,
    constraint pk_curriculolingua primary key (curriculo_id, lingua_id),
    constraint fk_curriculolingua_curriculo foreign key(curriculo_id) references curriculo(id),
    constraint fk_curriculolingua_lingua foreign key(lingua_id) references lingua(id)
);

CREATE TABLE IF NOT EXISTS curriculo_curso (
	curriculo_id binary(36) not null,
    curso_id binary(36) not null,
    constraint pk_curriculolingua primary key (curriculo_id, curso_id),
    constraint fk_curriculocurso_curriculo foreign key(curriculo_id) references curriculo(id),
    constraint fk_curriculocurso_curso foreign key(curso_id) references curso(id)
);

CREATE TABLE IF NOT EXISTS curriculo_exptrabalho (
	curriculo_id binary(36) not null,
    experienciatrabalho_id binary(36) not null,
    constraint pk_curriculoexptrabalho primary key (curriculo_id, experienciatrabalho_id),
    constraint fk_curriculoexptrabalho_curriculo foreign key(curriculo_id) references curriculo(id),
    constraint fk_curriculoexptrabalho_exptrabalho foreign key(experienciatrabalho_id) references experiencia_trabalho(id)
);
