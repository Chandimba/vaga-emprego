package ao.it.chandsoft.vagaemprego.controller;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import ao.it.chandsoft.vagaemprego.exception.FieldsNotValidException;
import ao.it.chandsoft.vagaemprego.service.CandidatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.*;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/candidatos")
public class CondidatoController {

    private CandidatoService candidatoService;

    @Autowired
    public CondidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public Candidato save(@RequestBody @Valid CandidatoDTO candidatoDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new FieldsNotValidException(candidatoDTO.getClass(), bindingResult.getFieldErrors());
        }

        candidatoDTO.setId(null);
        return candidatoService.save(candidatoDTO);
    }

    @GetMapping("/{id}")
    public Candidato findById(@PathVariable UUID id) {
        return candidatoService.findById(id);
    }
}
