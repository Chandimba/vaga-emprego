package ao.it.chandsoft.vagaemprego.repository;

import ao.it.chandsoft.vagaemprego.domain.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfissaoRepository extends JpaRepository<Profissao, UUID> {
}
