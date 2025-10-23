package com.TheCoderKushagra.service;

import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        Map<String, List<String>> schemaValue = new HashMap<>();
        List<String> requriedList = new ArrayList<>();
        List<String> optionalList = new ArrayList<>();
        schemaValue.put("required", requriedList);
        schemaValue.put("optional", optionalList);
        return categoryRepository.save(category);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }
}
