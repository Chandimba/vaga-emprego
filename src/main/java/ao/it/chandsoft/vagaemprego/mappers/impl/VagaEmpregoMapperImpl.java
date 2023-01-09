package ao.it.chandsoft.vagaemprego.mappers.impl;

import ao.it.chandsoft.vagaemprego.mappers.VagaEmpregoMapper;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Objects;

@Slf4j
public class VagaEmpregoMapperImpl<T, S> implements VagaEmpregoMapper<T, S> {

    /*/public Candidato toCandidato(CandidatoDTO candidatoDTO) {
        if (candidatoDTO == null) {
            return null;
        } else {
            Candidato candidato = new Candidato();
            candidato.setId(candidatoDTO.getId());
            candidato.setNome(candidatoDTO.getNome());
            candidato.setEmail(candidatoDTO.getEmail());
            Set<String> telefones = candidatoDTO.getTelefones();
            if (telefones != null) {
                candidato.setTelefones(new LinkedHashSet(telefones));
            }

            candidato.setDataNascimento(candidatoDTO.getDataNascimento());
            candidato.setNacionalidade(candidatoDTO.getNacionalidade());
            candidato.setCidade(candidatoDTO.getCidade());
            candidato.setMorada(candidatoDTO.getMorada());
            candidato.setDataRegisto(candidatoDTO.getDataRegisto());

            Set<Referencia> referencias = candidatoDTO.getReferencias();
            if (referencias != null) {
                candidato.setReferencias(new LinkedHashSet(referencias));
            }

            return candidato;
        }
    }*/

    @Override
    public T convert(S obj, Class<T> clazz) {
        try {
            Class objClass =  obj.getClass();
            T instance = clazz.newInstance();
            for (Field field: objClass.getDeclaredFields()) {
                try {
                    field.setAccessible(true);

                    Field fieldTo = instance.getClass().getDeclaredField(field.getName());
                    fieldTo.setAccessible(true);
                    if(Objects.nonNull(field.get(obj))) {
                        fieldTo.set(instance, field.get(obj));

                    }

                } catch (IllegalAccessException| IllegalArgumentException|SecurityException| NoSuchFieldException ex) {
                    log.error(field.getName(), ex);
                }
            }
            return instance;
        } catch (InstantiationException| IllegalArgumentException| IllegalAccessException ex) {
            log.error("Erro ao converter o ", ex);
        }
        return null;
    }

    private void copyAnnotations(Field source, Field destination) {

    }
}
