package com.TheCoderKushagra.entity;

import com.TheCoderKushagra.entity.keys.ProductAttributeKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_attributes")
@IdClass(ProductAttributeKey.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttribute {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id")
    private CategoryAttribute attribute;

    @Column(columnDefinition = "TEXT")
    private String attributeValue;

    private LocalDateTime updatedAt;
}
