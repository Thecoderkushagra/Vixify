package com.TheCoderKushagra.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Reference to Product Service (SQL table in another microservice)
    @Column(name = "product_id", nullable = false)
    private String productId;

    // Reference to User/Seller Service (Mongo document in another microservice)
    @Column(name = "seller_id", nullable = false)
    private String sellerId;

    @Column(nullable = false)
    private Integer stockQuantity;
}
