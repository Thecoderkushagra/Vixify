package com.theCoderKushagra.chatApp.Vixify.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {
    @Autowired
    private JavaMailSender pokemon;

    public void mailSender(String to, String subject, String body){
        try {
            SimpleMailMessage Mail = new SimpleMailMessage();
            Mail.setTo(to);
            Mail.setSubject(subject);
            Mail.setText(body);

            pokemon.send(Mail);

        } catch (Exception e) {
            log.error("Error while sending mail",e);
        }

    }

}
