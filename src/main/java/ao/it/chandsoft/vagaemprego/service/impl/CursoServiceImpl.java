package ao.it.chandsoft.vagaemprego.service.impl;

import ao.it.chandsoft.vagaemprego.domain.Curso;
import ao.it.chandsoft.vagaemprego.repository.CursoRepository;
import ao.it.chandsoft.vagaemprego.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CursoServiceImpl implements CursoService {

    private CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(UUID id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
