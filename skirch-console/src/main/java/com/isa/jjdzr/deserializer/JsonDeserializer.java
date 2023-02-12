package com.isa.jjdzr.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonDeserializer {
    public void deserialize() {
        ObjectMapper mapper = new ObjectMapper();
        String result;
        try {
            result = new String(Files.readAllBytes(Paths.get("skirch-console/src/main/resources/resorts.json")));
            List<Resort> resortsJsonList = mapper.readValue(result, new TypeReference<>() {
            });
            for (int i = 0; i < resortsJsonList.size(); i++) {
                System.out.println("--------------------- " + (i+1) + " ---------------------");
                System.out.println("Name: " + resortsJsonList.get(i).getData().getName());
                System.out.println("Country: " + resortsJsonList.get(i).getData().getCountry());
                System.out.println("Region: " + resortsJsonList.get(i).getData().getRegion());
                System.out.println("Href: " + resortsJsonList.get(i).getData().getHref());
                System.out.println("Location: " + resortsJsonList.get(i).getData().getLocation());
                System.out.println("Lifts stats: " + resortsJsonList.get(i).getData().getLifts().getStats());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
