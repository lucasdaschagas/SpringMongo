package com.mongospring.mongospringprojec.repository;

import com.mongospring.mongospringprojec.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
}
