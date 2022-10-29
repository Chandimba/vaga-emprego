package ao.it.chandsoft.vagaemprego.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.List;

public class FieldsNotValidException extends RuntimeException {

    @Getter
    private List<FieldError> fieldErros;

    public FieldsNotValidException(Class classe, List<FieldError> fieldErros) {
        super("Erros de validacao dos atributos da classe " + classe.getSimpleName());
        this.fieldErros = fieldErros;
    }
}
