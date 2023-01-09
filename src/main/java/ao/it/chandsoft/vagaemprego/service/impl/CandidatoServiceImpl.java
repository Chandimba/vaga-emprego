package ao.it.chandsoft.vagaemprego.service.impl;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.Profissao;
import ao.it.chandsoft.vagaemprego.domain.Referencia;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoFilterDTO;
import ao.it.chandsoft.vagaemprego.domain.dto.Paginacao;
import ao.it.chandsoft.vagaemprego.domain.dto.ReferenciaDTO;
import ao.it.chandsoft.vagaemprego.exception.CandidatoNotFoundException;
import ao.it.chandsoft.vagaemprego.exception.ProfissaoNotFoundException;
import ao.it.chandsoft.vagaemprego.mappers.impl.VagaEmpregoMapperImpl;
import ao.it.chandsoft.vagaemprego.repository.CandidatoRepository;
import ao.it.chandsoft.vagaemprego.repository.ProfissaoRepository;
import ao.it.chandsoft.vagaemprego.repository.ReferenciaRepository;
import ao.it.chandsoft.vagaemprego.service.CandidatoService;
import ao.it.chandsoft.vagaemprego.util.Assert;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CandidatoServiceImpl implements CandidatoService {

    private CandidatoRepository candidatoRepository;
    private ProfissaoRepository profissaoRepository;
    private ReferenciaRepository referenciaRepository;

    @Transactional(readOnly = false)
    @Override
    public Candidato save(CandidatoDTO candidatoDTO) {
        Profissao profissao = profissaoRepository.findById(candidatoDTO.getProfissaoId())
                .orElseThrow(() -> new ProfissaoNotFoundException("Nao existe profissao com id " + candidatoDTO.getProfissaoId()));

        Candidato candidato = new VagaEmpregoMapperImpl<Candidato, CandidatoDTO>().convert(candidatoDTO, Candidato.class);
        candidato.setProfissao(profissao);
        return candidatoRepository.save(candidato);
    }

    @Override
    public Paginacao<Candidato> findAll(CandidatoFilterDTO candidatoFilter, Pageable pageable) {
        return new Paginacao<>(
                candidatoRepository.findAll(
                        candidatoFilter.getNome(),
                        candidatoFilter.getCidade(),
                        candidatoFilter.getProfissaoDesignacao(),
                        candidatoFilter.getDataNascimento(),
                        candidatoFilter.getDataRegistoInicial(),
                        candidatoFilter.getDataRegistoFinal(),
                        pageable));
    }

    @Override
    public Candidato findById(UUID uuid) {

        if(Assert.isNull(uuid)) {
            throw new NullPointerException("O id do candidato e obrigatorio");
        }

        return candidatoRepository.findById(uuid)
                .orElseThrow(() -> new CandidatoNotFoundException("Nao foi encontrado um candidato com o id " + uuid.toString()));

    }

    @Override
    public Referencia saveReference(UUID candidatoId, ReferenciaDTO referenciaDTO) {
        Candidato candidato = findById(candidatoId);

        Referencia referencia = new VagaEmpregoMapperImpl<Referencia, ReferenciaDTO>().convert(referenciaDTO, Referencia.class);
        referencia.setCandidato(candidato);
        return referenciaRepository.save(referencia);
    }
}
