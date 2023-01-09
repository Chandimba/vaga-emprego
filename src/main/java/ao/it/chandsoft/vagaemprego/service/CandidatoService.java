package ao.it.chandsoft.vagaemprego.service;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.Referencia;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoFilterDTO;
import ao.it.chandsoft.vagaemprego.domain.dto.Paginacao;
import ao.it.chandsoft.vagaemprego.domain.dto.ReferenciaDTO;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CandidatoService {

    Candidato save(CandidatoDTO candidatoDTO);
    Paginacao<Candidato> findAll(CandidatoFilterDTO candidatoFilter, Pageable pageable);
    Candidato findById(UUID uuid);

    Referencia saveReference(UUID candidatoId, ReferenciaDTO referenciaDTO);

}
