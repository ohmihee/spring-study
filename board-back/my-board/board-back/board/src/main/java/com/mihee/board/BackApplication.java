package com.mihee.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class BackApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackApplication.class, args);
        System.out.println("test=========");
    }

}
