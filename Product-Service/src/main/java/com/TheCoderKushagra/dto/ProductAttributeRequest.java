package com.TheCoderKushagra.dto;

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
