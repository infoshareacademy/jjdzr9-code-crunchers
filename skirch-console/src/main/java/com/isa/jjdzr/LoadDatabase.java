package com.isa.jjdzr;

import com.isa.jjdzr.service.JsonMapper;

import static com.isa.jjdzr.SkirchCoreConstants.RESORTS_PATH;
import static com.isa.jjdzr.service.Database.getListOfResorts;

public class LoadDatabase {
    private final JsonMapper jsonMapper = new JsonMapper();

    public void loadDatabase() {
//        getListOfUsers().addAll(jsonMapper.deserialize(USERS_PATH));
        getListOfResorts().addAll(jsonMapper.deserialize(RESORTS_PATH));

    }
}
