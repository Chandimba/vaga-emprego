package ao.it.chandsoft.vagaemprego.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "designacao")
    private String designacao;
}
