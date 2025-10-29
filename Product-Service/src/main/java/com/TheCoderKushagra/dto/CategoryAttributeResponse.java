package com.TheCoderKushagra.dto;

import com.TheCoderKushagra.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryAttributeResponse {
    private String attributeId;
    private Category category;
    private String attributeName;
    private Boolean isRequired;
}
