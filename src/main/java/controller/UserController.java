package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService repository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1","Maria Brown","maria@gmail.com");
        User bob = new User("2","Bob Silver","bob@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria, bob));
        return ResponseEntity.ok().body(list);
    }
}
