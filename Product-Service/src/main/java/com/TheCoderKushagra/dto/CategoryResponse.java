package com.TheCoderKushagra.dto;

import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.entity.CategoryAttribute;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private String categoryId;
    private String categoryName;
    private Category parentCategory;
    private List<CategoryAttribute> attributes = new ArrayList<>();
}
