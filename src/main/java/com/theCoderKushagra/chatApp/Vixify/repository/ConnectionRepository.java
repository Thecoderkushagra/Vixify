package com.theCoderKushagra.chatApp.Vixify.repository;

import com.theCoderKushagra.chatApp.Vixify.entity.Connections;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConnectionRepository extends MongoRepository<Connections, String> {
    Optional<String> findBySenderIdAndRecipientId(String senderId, String recipientId);
}

