package ao.it.chandsoft.vagaemprego.repository;

import ao.it.chandsoft.vagaemprego.domain.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, UUID> {
}
