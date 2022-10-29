package ao.it.chandsoft.vagaemprego.service.impl;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.Profissao;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import ao.it.chandsoft.vagaemprego.exception.CandidatoNotFoundException;
import ao.it.chandsoft.vagaemprego.exception.ProfissaoNotFoundException;
import ao.it.chandsoft.vagaemprego.mappers.CandidatoMapper;
import ao.it.chandsoft.vagaemprego.repository.CandidatoRepository;
import ao.it.chandsoft.vagaemprego.repository.ProfissaoRepository;
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
    private ProfissaoRepository profissaoRepository;

    @Autowired
    public CandidatoServiceImpl(CandidatoRepository candidatoRepository, ProfissaoRepository profissaoRepository) {
        this.candidatoRepository = candidatoRepository;
        this.profissaoRepository = profissaoRepository;
    }

    @Override
    public Candidato save(CandidatoDTO candidatoDTO) {
        Profissao profissao = profissaoRepository.findById(candidatoDTO.getProfissaoId())
                .orElseThrow(() -> new ProfissaoNotFoundException("Nao existe profissao com id " + candidatoDTO.getProfissaoId()));

        Candidato candidato = candidatoDTO.toCandidato();
        candidato.setProfissao(profissao);
        return candidatoRepository.save(candidato);
    }

    @Override
    public Page<Candidato> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Candidato findById(UUID uuid) {

        if(Assert.isNull(uuid)) {
            throw new NullPointerException("O id do candidato e obrigatorio");
        }

        return candidatoRepository.findById(uuid.toString())
                .orElseThrow(() -> new CandidatoNotFoundException("Nao foi encontrado um candidato com o id " + uuid.toString()));

    }
}
