package com.isa.jjdzr.service;

import com.isa.jjdzr.model.User;

import java.util.List;

import static com.isa.jjdzr.SkirchCoreConstants.MAX_USER_ID_PATH;
import static com.isa.jjdzr.SkirchCoreConstants.USERS_PATH;
import static com.isa.jjdzr.service.IdGenerator.generateNewId;

public class UserService {
    private final JsonMapper jsonMapper = new JsonMapper();
    public void saveUser(User user) {
        int newId = generateNewId();
        user.setId(newId);
        Database.getListOfUsers().add(user);
        saveToFile(Database.getListOfUsers(), USERS_PATH);
        Database.setMaxUserId(newId);
        saveToFile(List.of(Database.getMaxUserId()), MAX_USER_ID_PATH);
    }
    public List<User> allUsers() {
        return Database.getListOfUsers();
    }
    private <T> void saveToFile(List<T> userList, String path) {
        jsonMapper.serialize(userList, path);
    }
}


