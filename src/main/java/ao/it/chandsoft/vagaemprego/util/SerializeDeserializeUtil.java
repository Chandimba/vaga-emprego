package ao.it.chandsoft.vagaemprego.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class SerializeDeserializeUtil {
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public static byte[] convertObjectToJsonBytes(Object object)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);

        return mapper.writeValueAsBytes(object);

    }

    public static <T> T deserializeObject(String jsonRepresentation,
                                          Class<T> clazz) throws JsonParseException, JsonMappingException,
            IOException {

        ObjectMapper mapper = new ObjectMapper();

        Object obj = mapper.readValue(jsonRepresentation.getBytes(), clazz);

        return clazz.cast(obj);
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static byte[] convertObjectToJsonBytesWithCustomSerializer(
            Object object, JsonSerializer serializer, Class clazz)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        SimpleModule sm = new SimpleModule();
        sm.addSerializer(clazz, serializer);

        mapper.registerModule(sm);
        mapper.setSerializationInclusion(Include.NON_NULL);

        return mapper.writeValueAsBytes(object);

    }
}
