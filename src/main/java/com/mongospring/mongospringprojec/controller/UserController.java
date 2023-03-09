package com.mongospring.mongospringprojec.controller;

import com.mongospring.mongospringprojec.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongospring.mongospringprojec.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService repository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }
}
