package ao.it.chandsoft.vagaemprego.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

public class UriUtil {

    public static URI addUuidToCurrentUrlPath(UUID uuid) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(uuid)
                .toUri();
    }

}
