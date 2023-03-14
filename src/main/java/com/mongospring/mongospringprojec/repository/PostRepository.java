package com.mongospring.mongospringprojec.repository;

import com.mongospring.mongospringprojec.domain.Post;
import com.mongospring.mongospringprojec.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{
    List<Post> findByTitleContainingIgnoreCase(String text);
}
