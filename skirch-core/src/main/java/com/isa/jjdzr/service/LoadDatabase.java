package com.isa.jjdzr.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.isa.jjdzr.dto.ResortExternalDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.isa.jjdzr.SkirchCoreConstants.RESORTS_PATH;
@Component
public class LoadDatabase {

    private static final JsonMapper jsonMapper = new JsonMapper();
    private static ResortServiceCore resortServiceCore;

    public LoadDatabase(ResortServiceCore resortServiceCore) {
        this.resortServiceCore = resortServiceCore;
    }

    public static void loadDatabase() {
        List<ResortExternalDto> listOfResorts = new ArrayList<>();
        listOfResorts.addAll(jsonMapper.deserialize(RESORTS_PATH, new TypeReference<List<ResortExternalDto>>() {
        }));
        resortServiceCore.saveAll(listOfResorts);

    }
}
