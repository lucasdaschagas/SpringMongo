package com.mongospring.mongospringprojec.services;

import com.mongospring.mongospringprojec.domain.Post;
import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.dto.UserDTO;
import com.mongospring.mongospringprojec.exception.ObjectNotFoundExeption;
import com.mongospring.mongospringprojec.repository.PostRepository;
import com.mongospring.mongospringprojec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
  private PostRepository repository;



    public Post findById(String id){
     Optional<Post> post = repository.findById(id);
       return post.orElseThrow(() -> new ObjectNotFoundExeption("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
      maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
      return repository.fullSearch(text, minDate, maxDate);
    }


}
