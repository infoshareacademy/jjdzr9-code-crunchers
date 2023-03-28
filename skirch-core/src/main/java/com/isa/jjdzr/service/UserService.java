package com.isa.jjdzr.service;

import com.isa.jjdzr.model.User;

import java.util.List;

public class UserService {
    private final JsonMapper jsonMapper = new JsonMapper();

    public UserService() {

    }

    public void saveUser(User user) {
        Database.getListOfUsers().add(user);
        saveToFile(Database.getListOfUsers());
    }

    public List<User> allUsers() {
        return Database.getListOfUsers();
    }

    private void saveToFile(List<User> userList){
     jsonMapper.serialize(userList);
    }
}

