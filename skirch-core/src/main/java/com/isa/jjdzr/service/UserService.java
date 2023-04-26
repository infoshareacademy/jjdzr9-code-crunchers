package com.isa.jjdzr.service;

import com.isa.jjdzr.model.User;

import java.util.List;

import static com.isa.jjdzr.service.IdGenerator.generateNewId;

public class UserService {
    private final JsonMapper jsonMapper = new JsonMapper();
    public void saveUser(User user) {
        int newId = generateNewId();
        user.setId(newId);
        Database.getListOfUsers().add(user);
        saveToFile(Database.getListOfUsers());
    }
    public List<User> allUsers() {
        return Database.getListOfUsers();
    }
    private void saveToFile(List<User> userList) {
        jsonMapper.serialize(userList);
    }
}


