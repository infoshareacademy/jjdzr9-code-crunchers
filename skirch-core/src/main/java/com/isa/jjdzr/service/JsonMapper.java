package com.isa.jjdzr.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.isa.jjdzr.SkirchCoreConstants.USERS_PATH;

public class JsonMapper {

    private ObjectMapper mapper = new ObjectMapper();

    public JsonMapper() {
    }

    public <T> List<T> deserialize(String path) {
        String result;
        List<T> list = new ArrayList<>();
        try {
            result = new String(Files.readAllBytes(Paths.get(path)));
            if (!result.isEmpty()) {
                list = mapper.readValue(result, new TypeReference<>() {
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public <T> void serialize(List<T> list) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(USERS_PATH));
            PrintWriter finalWriter = writer;
            list.forEach(object -> {
                try {
                   finalWriter.println(mapper.writeValueAsString(object));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
