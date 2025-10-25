package com.TheCoderKushagra.dto;

import com.TheCoderKushagra.entity.ProductAttribute;
import com.TheCoderKushagra.entity.ProductAttributeIndex;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private Double basePrice;

    private String brand;
    private String category;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<ProductAttribute> productAttributes = new ArrayList<>();
    private List<ProductAttributeIndex> attributeIndexes = new ArrayList<>();
}
