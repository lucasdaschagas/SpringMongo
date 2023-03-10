package com.mongospring.mongospringprojec.services;

import com.mongospring.mongospringprojec.domain.User;
import com.mongospring.mongospringprojec.dto.UserDTO;
import com.mongospring.mongospringprojec.repository.UserRepository;
import com.mongospring.mongospringprojec.exception.ObjectNotFoundExeption;
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

    public User insert (User obj){
      return repository.insert(obj);
    }

    public User fromDTO (UserDTO obj){
        return new User(obj.id(), obj.name(), obj.email());
    }

    public void deleteByIDs (String id){
        findById(id);
        repository.deleteById(id);
    }
    public User update (User obj){
        Optional<User> newObj = repository.findById(obj.getId());
        updateUserData(newObj.get(),obj);
        return repository.save(newObj.get());


    }

    public void updateUserData (User user, User data){
        user.setName(data.getName());
        user.setEmail(data.getEmail());
    }



}