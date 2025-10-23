package com.TheCoderKushagra.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryAttributeRequest {
    private String category;
    private String attributeName;
    private Boolean isRequired;
}
