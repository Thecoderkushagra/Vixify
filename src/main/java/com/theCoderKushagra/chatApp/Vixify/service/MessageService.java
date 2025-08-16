package com.theCoderKushagra.chatApp.Vixify.service;

import com.theCoderKushagra.chatApp.Vixify.entity.Message;
import com.theCoderKushagra.chatApp.Vixify.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ConnectionService connectionService;

    public Message saveMessage(Message msg){
        try{
            String chatId = String.valueOf(
                    connectionService.getConnectionChatId(msg.getSender(), msg.getReceiver())
            );
            msg.setChatId(chatId);
            return messageRepository.save(msg);
        } catch (Exception e) {
            log.error("run time Exception", e);
            return null;
        }
    }

    public void findChatMessages(String senderId, String recipientId) {
        var chatId = connectionService.getConnectionChatId(senderId, recipientId);
        chatId.map(messageRepository::findByChatId);
    }


}
