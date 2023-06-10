package com.isa.jjdzr.service;

import com.isa.jjdzr.dao.ResortsDao;
import com.isa.jjdzr.dto.ResortExternalDto;
import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Database {

    private static ResortsDao resortsDao;
    private static List<Data> listOfResortExternalDtos = new ArrayList<>();
    private static List<User> listOfUsers = new ArrayList<>();

    @Autowired
    public Database(ResortsDao resortsDao) {
        this.resortsDao=resortsDao;
    }

    public static List<ResortExternalDto> getListOfResorts() {
        return resortsDao.getAllResorts();
    }
    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

//    public static User findByEmail(String email){
//        return listOfUsers.stream().filter(n->n.getEmail().equals(email)).findFirst().get();
//    }

}

