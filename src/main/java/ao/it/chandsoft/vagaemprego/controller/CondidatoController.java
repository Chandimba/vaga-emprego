package ao.it.chandsoft.vagaemprego.controller;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoFilterDTO;
import ao.it.chandsoft.vagaemprego.domain.dto.Paginacao;
import ao.it.chandsoft.vagaemprego.exception.FieldsNotValidException;
import ao.it.chandsoft.vagaemprego.service.CandidatoService;
import ao.it.chandsoft.vagaemprego.util.UriUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.*;
import java.net.URI;
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
    public ResponseEntity save(@Valid @RequestBody CandidatoDTO candidatoDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new FieldsNotValidException(candidatoDTO.getClass(), bindingResult.getFieldErrors());
        }

        candidatoDTO.setId(null);
        Candidato candidatoSalvo = candidatoService.save(candidatoDTO);
        URI uri = UriUtil.addUuidToCurrentUrlPath(candidatoSalvo.getId());
        return ResponseEntity.created(uri).body(candidatoSalvo);
    }

    @GetMapping
    public Paginacao findAll(CandidatoFilterDTO candidatoFilter, Pageable pageable) {
        return candidatoService.findAll(candidatoFilter, pageable);
    }

    @GetMapping("/{id}")
    public Candidato findById(@PathVariable UUID id) {
        return candidatoService.findById(id);
    }
}
