package ao.it.chandsoft.vagaemprego.controller;

import ao.it.chandsoft.vagaemprego.domain.Curso;
import ao.it.chandsoft.vagaemprego.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("{id}")
    public Curso findById(@PathVariable UUID id) {
        return cursoService.findById(id);
    }

    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

}
