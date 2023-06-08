package com.isa.jjdzr;

import com.isa.jjdzr.service.LoadDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.isa.jjdzr")
public class SkirchWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkirchWebApplication.class, args);
        LoadDatabase.loadDatabase();

    }

}
