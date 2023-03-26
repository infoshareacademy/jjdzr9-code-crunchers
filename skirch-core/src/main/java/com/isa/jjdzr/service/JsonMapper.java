package com.isa.jjdzr.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonMapper {
    private ObjectMapper mapper = new ObjectMapper();

    public JsonMapper() {
    }

    public <T> List<T> deserialize(String path) {
        String result;
        List<T> resortsJsonList;
        try {
            result = new String(Files.readAllBytes(Paths.get(path)));
            resortsJsonList = mapper.readValue(result, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resortsJsonList;
    }
    // TODO - Maciej
    public <T> void serialize(T list){

    }

}
