package ao.it.chandsoft.vagaemprego.repository;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, String> {
}
