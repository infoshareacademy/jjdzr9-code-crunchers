package com.isa.jjdzr.service;

import com.isa.jjdzr.model.ResortExternalDto;
import com.isa.jjdzr.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<ResortExternalDto> listOfResortExternalDtos = new ArrayList<>();
    private static List<User> listOfUsers = new ArrayList<>();

    public static List<ResortExternalDto> getListOfResorts() {
        return listOfResortExternalDtos;
    }
    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

//    public static User findByEmail(String email){
//        return listOfUsers.stream().filter(n->n.getEmail().equals(email)).findFirst().get();
//    }

}

