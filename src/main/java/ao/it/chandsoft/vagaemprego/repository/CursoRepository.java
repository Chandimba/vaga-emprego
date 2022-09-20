package ao.it.chandsoft.vagaemprego.repository;

import ao.it.chandsoft.vagaemprego.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {

}
