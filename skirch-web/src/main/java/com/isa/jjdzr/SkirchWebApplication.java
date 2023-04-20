package com.isa.jjdzr;

import com.isa.jjdzr.service.LoadDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkirchWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(SkirchWebApplication.class, args);
        LoadDatabase.loadDatabase();

    }

}
