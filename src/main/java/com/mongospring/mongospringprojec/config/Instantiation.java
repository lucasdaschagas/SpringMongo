package com.mongospring.mongospringprojec.config;

import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.repository.UserRepository;
import com.mongospring.mongospringprojec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserService repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");


    }

}
