package ao.it.chandsoft.vagaemprego.service.impl;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import ao.it.chandsoft.vagaemprego.exception.CandidatoNotFoundException;
import ao.it.chandsoft.vagaemprego.repository.CandidatoRepository;
import ao.it.chandsoft.vagaemprego.service.CandidatoService;
import ao.it.chandsoft.vagaemprego.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CandidatoServiceImpl implements CandidatoService {


    private CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoServiceImpl(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    @Override
    public Candidato save(CandidatoDTO candidatoDTO) {
        return null;
    }

    @Override
    public Page<Candidato> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Candidato findById(UUID uuid) {

        if(Assert.isNotNull(uuid)) {
            throw new NullPointerException("O id do candidato e obrigatorio");
        }

        return candidatoRepository.findById(uuid.toString())
                .orElseThrow(() -> new CandidatoNotFoundException("Nao foi encontrado um candidato com o id " + uuid.toString()));

    }
}
