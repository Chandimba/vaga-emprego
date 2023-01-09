package ao.it.chandsoft.vagaemprego.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "referencia")
public class Referencia implements Serializable {
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
    @Column(name="telefone")
    private String telefone;
    @Column(name="cargo")
    private String cargo;
    @Column(name="relacao")
    private String relacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidato_id")
    @JsonBackReference
    private Candidato candidato;
}
