package ao.it.chandsoft.vagaemprego.domain.dto;

import ao.it.chandsoft.vagaemprego.domain.Profissao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class CandidatoDTO implements Serializable {

    private String id;
    private String nome;
    private String email;
    private Set<String> telefones;
    private LocalDate dataNascimento;
    private String profissaoId;
    private String nacionalidade;
    private String cidade;
    private String morada;
    private LocalDate dataRegisto;

}
