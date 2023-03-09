package com.mongospring.mongospringprojec.services;

import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.repository.UserRepository;
import com.mongospring.mongospringprojec.services.exception.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
  private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public void delete(String id){
       repository.deleteById(id);
    }

    public User findById(String id){
     Optional<User> user = repository.findById(id);
       return user.orElseThrow(() -> new ObjectNotFoundExeption("Object not found"));
    }



}