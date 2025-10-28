package com.TheCoderKushagra.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class UserEntity {
    @Id
    private String id;

    private String name;
    private String email;
    private String password;

    private Roles role;

    private CustomerProfile customerProfile;
    private SellerProfile sellerProfile;
    private AdminProfile adminProfile;
}
