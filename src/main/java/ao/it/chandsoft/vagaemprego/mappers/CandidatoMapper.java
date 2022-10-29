package ao.it.chandsoft.vagaemprego.mappers;

import ao.it.chandsoft.vagaemprego.domain.Candidato;
import ao.it.chandsoft.vagaemprego.domain.dto.CandidatoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidatoMapper {
    CandidatoMapper INSTANCE = Mappers.getMapper( CandidatoMapper.class );

    Candidato toCandidato(CandidatoDTO candidatoDTO);

}
