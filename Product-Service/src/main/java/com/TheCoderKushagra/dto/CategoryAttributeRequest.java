package com.TheCoderKushagra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAttributeRequest {
    private String category;
    private String attributeName;
    private Boolean isRequired;
}
