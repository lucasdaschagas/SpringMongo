package com.mongospring.mongospringprojec.domain;
import com.mongospring.mongospringprojec.dto.AuthorDTO;
import com.mongospring.mongospringprojec.dto.CommentsDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Document
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    private List<CommentsDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
