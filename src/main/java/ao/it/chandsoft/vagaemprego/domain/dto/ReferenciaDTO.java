package ao.it.chandsoft.vagaemprego.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ReferenciaDTO implements Serializable {
    @EqualsAndHashCode.Include
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private String relacao;
}
