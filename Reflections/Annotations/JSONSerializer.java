package Just_Java.Reflections.Annotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implement Serializer to serialize annotated attributes only
 */
public class JSONSerializer {

    /**
     * Serialize attributes annotated with "@JsonField"
     *
     * @param object
     * @return
     */
    public String serialize(Object object) {
        Map<String, String> map = new HashMap<>();
        try {
            Class<?> objectClass = object.getClass();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    map.putIfAbsent(field.getName(), (String) field.get(object));
                }
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
