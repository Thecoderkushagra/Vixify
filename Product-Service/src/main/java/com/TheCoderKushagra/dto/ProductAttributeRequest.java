package com.TheCoderKushagra.dto;

import com.TheCoderKushagra.entity.CategoryAttribute;
import com.TheCoderKushagra.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAttributeRequest {
    private String product;
    private String attribute;
    private String attributeValue;
    private LocalDateTime updatedAt;
}
