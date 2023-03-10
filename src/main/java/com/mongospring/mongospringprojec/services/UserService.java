package com.mongospring.mongospringprojec.services;

import com.mongospring.mongospringprojec.domain.User;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongospring.mongospringprojec.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
=======
import com.mongospring.mongospringprojec.repository.UserRepository;
import com.mongospring.mongospringprojec.services.exception.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
>>>>>>> e79ffd3809b0ce4ec9d1995dd21656305a873760

@Service
public class UserService {

    @Autowired
  private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

<<<<<<< HEAD
    public void deleteAll() {
        repository.deleteAll();
    }
    public void deleteById(String id)
    {
        repository.deleteById(id);
    }


}
=======
    public void delete(String id){
       repository.deleteById(id);
    }

    public User findById(String id){
     Optional<User> user = repository.findById(id);
       return user.orElseThrow(() -> new ObjectNotFoundExeption("Object not found"));
    }



}
>>>>>>> e79ffd3809b0ce4ec9d1995dd21656305a873760
