package com.isa.jjdzr.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> userList = new ArrayList<>();
    public UserService() {
        User newUser = new User();
        saveUser(newUser);
    }
    public void saveUser(User user) {
        userList.add(user);
        System.out.println("User " + user.getUsername() + " saved.");
    }
    public List<User> getUserList() {
        return userList;
    }
}
