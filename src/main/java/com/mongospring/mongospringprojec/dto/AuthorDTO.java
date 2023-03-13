package com.mongospring.mongospringprojec.dto;

import com.mongospring.mongospringprojec.domain.User;

public record AuthorDTO
        (

    String id,
    String name

){
    public AuthorDTO(User user){
        this(user.getId(), user.getName());
    }
}

