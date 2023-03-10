package com.isa.jjdzr.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonDeserializer {
    public static List<Resort> deserialize() {
        ObjectMapper mapper = new ObjectMapper();
        String result;
        List<Resort> resortsJsonList;
        try {
            result = new String(Files.readAllBytes(Paths.get("src/main/resources/resorts.json")));
            resortsJsonList = mapper.readValue(result, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resortsJsonList;
    }

}
