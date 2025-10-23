package com.TheCoderKushagra.entity;

import com.TheCoderKushagra.entity.keys.ProductAttributeIndexKey;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_attribute_index")
@IdClass(ProductAttributeIndexKey.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAttributeIndex {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    private String attributeName;

    private String stringValue;
    private Double numericValue;
    private Boolean booleanValue;
    private LocalDateTime dateValue;
}
