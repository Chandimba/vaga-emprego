package ao.it.chandsoft.vagaemprego.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class CandidatoFilterDTO implements Serializable {

    private String nome;
    private String profissaoDesignacao;
    private String cidade;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataRegistoInicial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataRegistoFinal;

}
