package com.theCoderKushagra.chatApp.Vixify.repository;

import com.theCoderKushagra.chatApp.Vixify.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<Users, String> {
    Users findByUserName(String username);
    void deleteByUserName(String username);
}
