package com.isa.jjdzr.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.isa.jjdzr.model.Resort;
import com.isa.jjdzr.model.User;
import com.isa.jjdzr.service.JsonMapper;

import java.util.Collection;
import java.util.List;

import static com.isa.jjdzr.SkirchCoreConstants.MAX_USER_ID_PATH;
import static com.isa.jjdzr.SkirchCoreConstants.RESORTS_PATH;
import static com.isa.jjdzr.SkirchCoreConstants.USERS_PATH;
import static com.isa.jjdzr.service.Database.getListOfResorts;
import static com.isa.jjdzr.service.Database.getListOfUsers;
import static com.isa.jjdzr.service.Database.getMaxUserId;
import static com.isa.jjdzr.service.Database.setMaxUserId;

public class LoadDatabase {
    private static final JsonMapper jsonMapper = new JsonMapper();

    public static void loadDatabase() {
        // TODO Maciej obsłużyć możliwy NullPointerException na wzór linii 28-34
        getListOfUsers().addAll(jsonMapper.deserialize(USERS_PATH, new TypeReference<List<User>>() {
        }));
        getListOfResorts().addAll(jsonMapper.deserialize(RESORTS_PATH, new TypeReference<List<Resort>>() {
        }));
        final var maxUserId = jsonMapper.deserialize(MAX_USER_ID_PATH, new TypeReference<List<Integer>>() {
        });
        if (maxUserId == null) {
            setMaxUserId(0);
        } else {
            setMaxUserId(maxUserId.get(0));
        }
    }
}
