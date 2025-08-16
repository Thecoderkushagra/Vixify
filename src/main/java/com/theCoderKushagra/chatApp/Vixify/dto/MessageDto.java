package com.theCoderKushagra.chatApp.Vixify.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private String id;
    private String sender;
    private String receiver;
    private String content;
}
