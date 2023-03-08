package com.mongospring.mongospringprojec.services;

import com.mongospring.mongospringprojec.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongospring.mongospringprojec.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
  private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
    public void deleteById(String id)
    {
        repository.deleteById(id);
    }


}
