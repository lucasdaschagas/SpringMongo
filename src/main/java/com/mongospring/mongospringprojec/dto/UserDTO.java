package com.mongospring.mongospringprojec.dto;

import com.mongospring.mongospringprojec.domain.User;

import java.io.Serializable;

public record UserDTO(

    String id,
    String name,
    String email
){
    public UserDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}

