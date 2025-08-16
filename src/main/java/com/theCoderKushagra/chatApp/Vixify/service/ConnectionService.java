package com.theCoderKushagra.chatApp.Vixify.service;

import com.theCoderKushagra.chatApp.Vixify.entity.Connections;
import com.theCoderKushagra.chatApp.Vixify.repository.ConnectionRepository;
import com.theCoderKushagra.chatApp.Vixify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConnectionService {
    @Autowired
    private ConnectionRepository connectionRepository;
    @Autowired
    private UserRepository userRepository;

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);
        Connections senderRecipient = Connections
                .builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();
        Connections recipientSender = Connections
                .builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();
        connectionRepository.save(senderRecipient);
        connectionRepository.save(recipientSender);
        return chatId;
    }

    public Optional<String> getConnectionChatId(
            String senderId,
            String recipientId
    )
    {
        Optional<String> findChatId = connectionRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        if(findChatId.isPresent()){
            return findChatId;
        }
        else {
            boolean firstId = userRepository.existsById(senderId);
            boolean secondId = userRepository.existsById(recipientId);
            if (firstId && secondId){
                String newChatId = createChatId(senderId, recipientId);
                return Optional.of(newChatId);
            }else {
                return Optional.empty();
            }
        }
    }


}


