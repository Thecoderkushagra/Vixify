package com.TheCoderKushagra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // userId from MongoDB user service
    private String userId;
    private String orderStatus; // PENDING, PAID, SHIPPED, DELIVERED, CANCELLED
    private BigDecimal totalAmount;
    private String paymentMethod; // e.g., CARD, COD, WALLET
    private LocalDateTime orderDate = LocalDateTime.now();
    private String shippingAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

}
