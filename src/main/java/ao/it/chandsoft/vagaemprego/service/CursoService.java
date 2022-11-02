package ao.it.chandsoft.vagaemprego.service;

import ao.it.chandsoft.vagaemprego.domain.Curso;

import java.util.List;
import java.util.UUID;

public interface CursoService {

    List<Curso> findAll();

    Curso findById(UUID id);
}
