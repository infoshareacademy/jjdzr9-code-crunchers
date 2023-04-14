package com.isa.jjdzr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.isa.jjdzr.model.Resort;
import com.isa.jjdzr.service.JsonMapper;
import java.util.List;

import static com.isa.jjdzr.SkirchCoreConstants.RESORTS_PATH;
import static com.isa.jjdzr.service.Database.getListOfResorts;

public class LoadDatabase {
    private static final JsonMapper jsonMapper = new JsonMapper();

    public static void loadDatabase() {
//        getListOfUsers().addAll(jsonMapper.deserialize(USERS_PATH));
        getListOfResorts().addAll(jsonMapper.deserialize(RESORTS_PATH, new TypeReference<List<Resort>>() {
        }));

    }
}
