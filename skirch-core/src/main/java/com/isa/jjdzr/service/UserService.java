package com.isa.jjdzr.service;

import com.isa.jjdzr.model.User;

import java.util.List;

import static com.isa.jjdzr.service.IdGenerator.generateNewId;

public class UserService {
    private final JsonMapper jsonMapper = new JsonMapper();
    private Database database;

    public User saveUser(User newUser) {
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setMatchingPassword(newUser.getMatchingPassword());
        int newId = generateNewId();
        user.setId(newId);
        Database.getListOfUsers().add(user);
        saveToFile(Database.getListOfUsers());
        return user;
    }
    
    public List<User> allUsers() {
        return Database.getListOfUsers();
    }

    private void saveToFile(List<User> userList) {
        jsonMapper.serialize(userList);
    }


//    public User registerNewUser(List<User> allUsers) throws RuntimeException {
//        if (emailExists(user.getEmail())) {
//            throw new RuntimeException("There is an account with that email address: "
//                    + user.getEmail());
//        }
//        User newUser = new User();
//        newUser.setUsername(user.getUsername());
//        newUser.setPassword(user.getPassword());
//        newUser.setEmail(user.getEmail());
//
//        return database.getListOfUsers().add(newUser);
//    }

//    private boolean emailExists (String email){
//        return database.findByEmail(email)!= null;
//    }



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        return null;
//    }
}


