package ao.it.chandsoft.vagaemprego.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {

    @Id
    private String id;
    private String nome;
    @Column(name = "email")
    private String email;
    @ElementCollection
    @CollectionTable(name = "telefone", joinColumns = @JoinColumn(name = "candidato_id"))
    private Set<String> telefones;
    private LocalDate dataNascimento;
    @OneToOne
    private Profissao profissao;
    private String nacionalidade;
    private String cidade;
    private String morada;
    @CreatedDate
    private LocalDate dataRegisto;
    @Transient
    private int idade;

    public Integer getIdade() {
        return dataNascimento != null? (int) ChronoUnit.YEARS.between(dataNascimento, LocalDate.now()): null;
    }

    @PrePersist
    public void init() {
        id = UUID.randomUUID().toString();
    }
}
