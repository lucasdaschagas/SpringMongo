package services;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
  private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
