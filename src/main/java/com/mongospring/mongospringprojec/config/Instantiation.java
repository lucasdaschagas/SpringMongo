package com.mongospring.mongospringprojec.config;

import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.repository.UserRepository;
<<<<<<< HEAD
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

=======
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
>>>>>>> e79ffd3809b0ce4ec9d1995dd21656305a873760
}
