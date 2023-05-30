package com.isa.jjdzr.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.isa.jjdzr.model.ResortExternalDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.isa.jjdzr.SkirchCoreConstants.RESORTS_PATH;
import static com.isa.jjdzr.service.Database.getListOfResorts;
@Component
public class LoadDatabase {

    private static final JsonMapper jsonMapper = new JsonMapper();
    private static ResortServiceCore resortServiceCore;

    public LoadDatabase(ResortServiceCore resortServiceCore) {
        this.resortServiceCore = resortServiceCore;
    }

    public static void loadDatabase() {
        System.out.println("ResortServiceCore: " + resortServiceCore);
        getListOfResorts().addAll(jsonMapper.deserialize(RESORTS_PATH, new TypeReference<List<ResortExternalDto>>() {
        }));
        resortServiceCore.saveAll(getListOfResorts());

    }
}
