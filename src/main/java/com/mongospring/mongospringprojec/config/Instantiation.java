package com.mongospring.mongospringprojec.config;

import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User maria = new User("1","Maria Brown", "mariabrown@gmail.com");
        User bob = new User("2","Bob Green", "bobgreen@gmail.com");
        User mark = new User("3","Mark Blue", "markblue@gmail.com");

        repository.saveAll(Arrays.asList(maria,bob,mark));
    }
}
