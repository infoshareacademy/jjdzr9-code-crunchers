package com.isa.jjdzr.service;

import com.isa.jjdzr.model.Resort;
import com.isa.jjdzr.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Resort> listOfResorts = new ArrayList<>();
    private static List<User> listOfUsers = new ArrayList<>();
    public static List<Resort> getListOfResorts() {
        return listOfResorts;
    }
    public static List<User> getListOfUsers(){
        return listOfUsers;
    };

}