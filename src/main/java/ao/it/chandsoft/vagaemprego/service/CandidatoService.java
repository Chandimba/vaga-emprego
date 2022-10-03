package ao.it.chandsoft.vagaemprego.service;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CandidatoService {

    Candidato save(CandidatoDTO candidatoDTO);
    Page<Candidato> findAll(Pageable pageable);
    Candidato findById(UUID uuid);

}
