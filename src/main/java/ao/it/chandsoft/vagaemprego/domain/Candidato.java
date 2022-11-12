package ao.it.chandsoft.vagaemprego.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String nome;
    @Column(name = "email")
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "telefone", joinColumns = @JoinColumn(name = "candidato_id"))
    @Column(name="numero")
    private Set<String> telefones;
    private LocalDate dataNascimento;
    @OneToOne
    private Profissao profissao;
    private String nacionalidade;
    private String cidade;
    private String morada;
    @CreatedDate
    private LocalDate dataRegisto;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidato_id")
    private List<Referencia> referencias;

    public Integer getIdade() {
        return dataNascimento != null? (int) ChronoUnit.YEARS.between(dataNascimento, LocalDate.now()): null;
    }

    @PrePersist
    public void init() {
        id = UUID.randomUUID();
        dataRegisto = LocalDate.now();
    }
}
