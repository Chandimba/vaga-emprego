package ao.it.chandsoft.vagaemprego.repository;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, UUID> {


    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "teste_entity_graph")
    @Query(value = "SELECT DISTINCT c " +
            "FROM Candidato c " +
            "LEFT JOIN c.telefones t " +
            "LEFT JOIN c.profissao p " +
            "LEFT JOIN c.referencias r " +
            "WHERE 1 = 1 " +
                "AND (:nomeCandidato IS NULL OR UPPER(c.nome) LIKE CONCAT('%',UPPER(:nomeCandidato), '%')) " +
                "AND (:cidade IS NULL OR c.cidade = :cidade ) " +
                "AND (:designacaoProfissao IS NULL OR p.designacao = :designacaoProfissao) " +
                "AND (:dataNascimento IS NULL OR c.dataNascimento = :dataNascimento) " +
                "AND (:dataRegistoInicial IS NULL OR c.dataRegisto >= :dataRegistoInicial) " +
                "AND (:dataRegistoFinal IS NULL OR c.dataRegisto <= :dataRegistoFinal)"
    )
    Page<Candidato> findAll(
            @Param("nomeCandidato") String nome,
            @Param("cidade") String cidade,
            @Param("designacaoProfissao") String profissaoDesignacao,
            @Param("dataNascimento") LocalDate dataNascimento,
            @Param("dataRegistoInicial") LocalDate dataRegistoInicial,
            @Param("dataRegistoFinal") LocalDate dataRegistoFinal,
            Pageable pageable);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "teste_entity_graph")
    Optional<Candidato> findById(UUID id);
}
