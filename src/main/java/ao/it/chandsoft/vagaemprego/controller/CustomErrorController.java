package ao.it.chandsoft.vagaemprego.controller;

import ao.it.chandsoft.vagaemprego.error.ErroResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("error")
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes = new DefaultErrorAttributes();

    @GetMapping
    public ErroResponse error(WebRequest request, HttpServletResponse response) {
        Map<String, Object> errors = this.errorAttributes.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        return ErroResponse.builder()
                .codigoHttp(response.getStatus())
                .titulo(errors.get("error").toString())
                .detelhes(errors)
                .build();
    }

}
