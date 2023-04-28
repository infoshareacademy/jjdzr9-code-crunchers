package com.isa.jjdzr.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.jjdzr.model.Resort;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;

import static com.isa.jjdzr.SkirchCoreConstants.USERS_PATH;

public class JsonMapper {

    private ObjectMapper mapper = new ObjectMapper();

    public JsonMapper() {
    }

    public <T> T deserialize(String path, TypeReference<T> typeReference) {
        T result = null;
        try {
            final var stringValue = new String(Files.readAllBytes(Paths.get(path)));
            if (!stringValue.isEmpty()) {
                result = mapper.readValue(stringValue, typeReference);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public <T> void serialize(List<T> list, String path) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(path));
            PrintWriter finalWriter = writer;
            try {
                finalWriter.println(mapper.writeValueAsString(list));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
