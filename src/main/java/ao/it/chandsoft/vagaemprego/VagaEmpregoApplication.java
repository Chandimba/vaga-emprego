package ao.it.chandsoft.vagaemprego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication//(exclude = {ErrorMvcAutoConfiguration.class})
public class VagaEmpregoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VagaEmpregoApplication.class, args);
    }

}
