package com.mongospring.mongospringprojec.controller;
import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.dto.UserDTO;
import com.mongospring.mongospringprojec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService repository;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = repository.findAll();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);

    }

    @RequestMapping(value = "/{id}")
    @GetMapping
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = repository.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));

    }


    @PostMapping
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO data, UriComponentsBuilder uriBuilder) {
        User obj = repository.fromDTO(data);
        obj = repository.insert(obj);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        repository.deleteByIDs(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> insertUser(@RequestBody UserDTO data, @PathVariable String id) {
        User obj = repository.fromDTO(data);
        obj.setId(id);
        obj = repository.update(obj);
        return ResponseEntity.ok().body(new UserDTO(obj));

    }

}
