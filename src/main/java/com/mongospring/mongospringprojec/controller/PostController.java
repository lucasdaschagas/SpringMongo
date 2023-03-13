package com.mongospring.mongospringprojec.controller;

import com.mongospring.mongospringprojec.domain.Post;
import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.dto.UserDTO;
import com.mongospring.mongospringprojec.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService repository;
    @RequestMapping(value = "/{id}")
    @GetMapping
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = repository.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
