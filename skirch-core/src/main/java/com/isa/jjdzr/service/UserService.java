package com.isa.jjdzr.service;

import com.isa.jjdzr.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public List<User> allUsers() {
        return users;
    }
}

