package com.theCoderKushagra.chatApp.Vixify.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VarifyUserDto {
    @NonNull
    private String otp;
    @NonNull
    private String user;
}
