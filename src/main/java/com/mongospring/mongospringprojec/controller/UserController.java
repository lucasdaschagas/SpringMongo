package com.mongospring.mongospringprojec.controller;

import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongospring.mongospringprojec.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService repository;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = repository.findAll();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
       return ResponseEntity.ok().body(listDTO);

    }
    @RequestMapping(value = "/{id}")
    @GetMapping
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = repository.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));

    }


}
