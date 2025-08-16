package com.theCoderKushagra.chatApp.Vixify.dto;

import lombok.Data;
import java.util.List;

@Data
public class DisplayUserDto {
    private String id;
    private String userName;
    private String email;
    private List<String> roles;
}
