package ao.it.chandsoft.vagaemprego.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {

    @Id
    private String id;
    private String nome;
    private String email;
    @ElementCollection
    @CollectionTable(name = "telefone", joinColumns = @JoinColumn(name = "candidato_id"))
    @JoinColumn(name = "numero")
    private Set<String> telefones;
    private LocalDate dataNascimento;
    @OneToOne
    private Profissao profissao;
    private String nacionalidade;
    private String cidade;
    private String morada;
    private LocalDate dataRegisto;
    private int idade;


}
