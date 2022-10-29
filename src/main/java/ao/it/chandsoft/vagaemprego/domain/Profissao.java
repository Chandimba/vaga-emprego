package ao.it.chandsoft.vagaemprego.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {
    @Id
    private String id;
    private String designacao;
}
