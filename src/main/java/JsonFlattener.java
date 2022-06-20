import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Util to flatten a given json string
 */
public class JsonFlattener {

    public static final String EMPTY_PREFIX = "";
    public static final String SEPERATOR = ".";
    public static final String OPEN_BRACE = "[";
    public static final String CLOSE_BRACE = "]";

    /*
     * Convert a json string to flattened String
     * Returns null if input is null or invalid json
     * Returns empty if input is empty
     *
     */
    public static String flatten(String jsonText) {
        String flatJsonStr = null;
        if (StringUtils.isNotEmpty(jsonText)) {
            try {
                Gson gson = new Gson();
                Map<String, Object> jsonMap = gson.fromJson(jsonText, Map.class);
                Map<String, String> flattenedMap = flatten(EMPTY_PREFIX, jsonMap);
                flatJsonStr = gson.toJson(flattenedMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flatJsonStr;
    }

    /*
     * Flatten the json string, iteratively
     * Returns a Map of String (key) and Object (values)
     */
    private static Map flatten(String prefix, Map<String, Object> jsonMap) {

        Map flattenedMap = new LinkedHashMap(); //for ordering
        if (jsonMap != null) {
            if (StringUtils.isNotEmpty(prefix)) {
                prefix = prefix + SEPERATOR;
            }

            for (String aKey : jsonMap.keySet()) {
                Object value = jsonMap.get(aKey);
                if (value instanceof Map) {
                    flattenedMap.putAll(flatten(prefix + aKey, (Map) value));
                } else if (value instanceof Collection) {
                    int counter = 0;
                    for (Object eachValue : (Collection) value) {
                        flattenedMap.putAll(flatten(prefix + aKey + OPEN_BRACE + counter + CLOSE_BRACE, (Map) eachValue));
                        counter++;
                    }
                } else {
                    flattenedMap.put(prefix + aKey, value);
                }
            }
        }
        return flattenedMap;
    }
}
