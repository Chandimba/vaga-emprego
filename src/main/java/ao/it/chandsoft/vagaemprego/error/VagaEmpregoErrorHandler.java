package ao.it.chandsoft.vagaemprego.error;

import ao.it.chandsoft.vagaemprego.exception.FieldsNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class VagaEmpregoErrorHandler {

    @ExceptionHandler(FieldsNotValidException.class)
    public ResponseEntity fieldErrorNotValid(FieldsNotValidException exception) {
        return ResponseEntity.badRequest()
                .body(ErroResponse.builder()
                        .codigoHttp(400)
                        .titulo("Erro de validacao dos atributos")
                        .detelhes(exception.getFieldErros().stream()
                                .map(FieldError::getDefaultMessage)
                                .collect(Collectors.toList())
                        )
                        .build()
                );

    }

}
