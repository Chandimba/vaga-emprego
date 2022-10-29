package ao.it.chandsoft.vagaemprego.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErroResponse {
    private int codigoHttp;
    private String titulo;
    private Object detelhes;
}
