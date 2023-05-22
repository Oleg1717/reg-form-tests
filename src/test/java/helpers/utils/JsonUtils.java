package helpers.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static <T> T jsonStringToObject(String jsonString, Class<T> tClass) {
        T entity;
        try {
            entity = new ObjectMapper().readValue(jsonString, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public static <T> String jsonObjectToString(T jsonData) {
        String jsonAsString;
        try {
            jsonAsString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonAsString;
    }
}
