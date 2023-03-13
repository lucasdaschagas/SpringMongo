package com.mongospring.mongospringprojec.domain;


import jdk.jfr.Enabled;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class User implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    private String id;
    private  String name;
    private  String email;
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
