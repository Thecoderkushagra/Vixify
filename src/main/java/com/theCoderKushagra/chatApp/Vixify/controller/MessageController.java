package com.theCoderKushagra.chatApp.Vixify.controller;

import com.theCoderKushagra.chatApp.Vixify.dto.MessageDto;
import com.theCoderKushagra.chatApp.Vixify.entity.Message;
import com.theCoderKushagra.chatApp.Vixify.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/send-messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void sendMessage(@Payload Message message){
        Message savedMsg = messageService.saveMessage(message);
        MessageDto payload = new MessageDto(
                savedMsg.getId(),
                savedMsg.getSender(),
                savedMsg.getReceiver(),
                savedMsg.getContent()
        );
        messagingTemplate.
                convertAndSendToUser(message.getReceiver(), "/queue/messages", payload);
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<Message>> findChatMessages(
            @PathVariable String senderId,
            @PathVariable String recipientId
    ) {
        messageService.findChatMessages(senderId, recipientId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
