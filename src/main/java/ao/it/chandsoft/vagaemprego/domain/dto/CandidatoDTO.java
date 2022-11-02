package ao.it.chandsoft.vagaemprego.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CandidatoDTO implements Serializable {

    private UUID id;
    @NotBlank(message = "O nome do candidado é obrigatório")
    private String nome;
    @NotEmpty(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail do candidado não é válido")
    private String email;
    @NotNull(message = "Deve adicionar pelo menos um telefone na lista de telefones ")
    private Set<String> telefones;
    @Past(message = "A data de nascimento deve ser inferior a data actual")
    @NotNull(message = "A data de nascimento do candidato é obrigatória")
    private LocalDate dataNascimento;
    @NotNull(message = "O id da profissão do candidado é obrigatório")
    private UUID profissaoId;
    @NotBlank(message = "A nacionalidade do candidado é obrigatória")
    private String nacionalidade;
    @NotBlank(message = "A cidade do candidado é obrigatória")
    private String cidade;
    @NotBlank(message = "A morada do candidado é obrigatória")
    private String morada;
    private LocalDate dataRegisto;

}
