package com.TheCoderKushagra.service;

import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }
}
