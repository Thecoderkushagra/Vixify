package com.theCoderKushagra.chatApp.Vixify.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class RequestUserDto{
    @NonNull
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
