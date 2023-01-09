package ao.it.chandsoft.vagaemprego.mappers;

//@Mapper
public interface VagaEmpregoMapper<T, S> {
    //CandidatoMapper INSTANCE = Mappers.getMapper( CandidatoMapper.class );

    //Candidato toCandidato(CandidatoDTO candidatoDTO);
    T convert(S from, Class<T> toClass);
}
