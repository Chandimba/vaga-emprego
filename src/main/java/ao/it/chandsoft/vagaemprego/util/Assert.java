package ao.it.chandsoft.vagaemprego.util;

import java.util.Collection;

public class Assert {

    public static boolean isNotBlank(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(Collection collection) {
        return collection != null;
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }
}
