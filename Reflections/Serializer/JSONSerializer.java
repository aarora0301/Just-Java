package Just_Java.Reflections.Serializer;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implement Serializer using Reflections
 */
public class JSONSerializer {

    /**
     * Serialize all the attributes of class
     * @param object
     * @return
     */
    public String serialize(Object object) {
        Map<String, String> map = new HashMap<>();
        try {
            Class<?> objectClass = (object).getClass();

            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                map.putIfAbsent(field.getName(), (String) field.get(object));
            }
        } catch (IllegalAccessException ex) {

        }
        return toJsonSTring(map);
    }

    private String toJsonSTring(Map<String, String> map) {
        String elements = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.joining(", "));
        return " { " + elements + " } ";

    }
}
