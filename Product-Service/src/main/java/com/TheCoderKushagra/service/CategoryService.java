package com.TheCoderKushagra.service;

import com.TheCoderKushagra.dto.CategoryRequest;
import com.TheCoderKushagra.dto.CategoryResponse;
import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.repository.CategoryAttributeRepository;
import com.TheCoderKushagra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired

    private CategoryAttributeRepository categoryAttributeRepository;

    public CategoryResponse createCategory(CategoryRequest request) {
        Category byCategoryName = categoryRepository.findByCategoryName(request.getParentCategory());
        Category category = Category.builder()
                .categoryName(request.getCategoryName())
                .parentCategory(byCategoryName)
                .build();
        Category saved = categoryRepository.save(category);
        return CategoryResponse.builder()
                .categoryId(saved.getCategoryId())
                .categoryName(saved.getCategoryName())
                .parentCategory(saved.getParentCategory())
                .attributes(saved.getAttributes())
                .build();
    }
}
