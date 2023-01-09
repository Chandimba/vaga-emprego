package ao.it.chandsoft.vagaemprego.error;

import ao.it.chandsoft.vagaemprego.exception.CandidatoNotFoundException;
import ao.it.chandsoft.vagaemprego.exception.FieldsNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class VagaEmpregoErrorHandler {

    @ExceptionHandler(FieldsNotValidException.class)
    public ResponseEntity fieldErrorNotValid(FieldsNotValidException exception) {
        return ResponseEntity.badRequest()
                .body(ErroResponse.builder()
                        .codigoHttp(HttpStatus.BAD_REQUEST.value())
                        .titulo("Erro de validação dos atributos")
                        .detelhes(exception.getFieldErros().stream()
                                .map(FieldError::getDefaultMessage)
                                .collect(Collectors.toList())
                        )
                        .build()
                );

    }

    @ExceptionHandler(CandidatoNotFoundException.class)
    public ResponseEntity fieldErrorNotValid(CandidatoNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErroResponse.builder()
                        .codigoHttp(HttpStatus.NOT_FOUND.value())
                        .titulo("Candidato nao encontrado")
                        .detelhes(exception.getMessage())
                        .build()
                );

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity fieldErrorNotValid(MethodArgumentTypeMismatchException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErroResponse.builder()
                        .codigoHttp(HttpStatus.BAD_REQUEST.value())
                        .titulo("Parametro invalido")
                        .detelhes(new String[]{exception.getName(), exception.getPropertyName(), exception.getMessage()})
                        .build()
                );

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity fieldErrorNotValid(HttpRequestMethodNotSupportedException exception) {
        String metodosSuportados = Stream.of(exception.getSupportedMethods())
                .collect(Collectors.joining(",", "Lista de metodos http suportados: ", ""));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErroResponse.builder()
                        .codigoHttp(HttpStatus.BAD_REQUEST.value())
                        .titulo(String.format("Metodo '%s' HTTP nao suportado", exception.getMethod()))
                        .detelhes(new String[] {
                                        String.format("O metodo '%s' http adicionado na requisicao nao eh suportado.", exception.getMethod()),
                                        metodosSuportados}
                        )
                        .build()
                );

    }

}
