package com.mongospring.mongospringprojec.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CommentsDTO implements Serializable {
    private static long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDTO authorDTO;
}
