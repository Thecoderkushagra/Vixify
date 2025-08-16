package com.theCoderKushagra.chatApp.Vixify.repository;

import com.theCoderKushagra.chatApp.Vixify.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByChatId(String chatId);
}

