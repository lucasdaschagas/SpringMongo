package com.mongospring.mongospringprojec.controller;

import com.mongospring.mongospringprojec.controller.util.URL;
import com.mongospring.mongospringprojec.domain.Post;
import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.dto.UserDTO;
import com.mongospring.mongospringprojec.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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

    @GetMapping
    @RequestMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = repository.findByTitle(text);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping
    @RequestMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = repository.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
