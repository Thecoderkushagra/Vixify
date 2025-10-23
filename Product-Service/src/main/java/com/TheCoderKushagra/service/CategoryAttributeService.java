package com.TheCoderKushagra.service;

import com.TheCoderKushagra.dto.CategoryAttributeRequest;
import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.entity.CategoryAttribute;
import com.TheCoderKushagra.repository.CategoryAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryAttributeService {
    @Autowired
    private CategoryAttributeRepository categoryAttributeRepository;

    @Autowired
    private CategoryService categoryService;

    public CategoryAttribute saveCategoryAttribute(CategoryAttributeRequest attribute) {
        Category categoryByName = categoryService.findCategoryByName(attribute.getCategory());

        CategoryAttribute myCategoryAttribute = CategoryAttribute.builder()
                .category(categoryByName)
                .attributeName(attribute.getAttributeName())
                .isRequired(attribute.getIsRequired())
                .build();
        return categoryAttributeRepository.save(myCategoryAttribute);
    }

    public CategoryAttribute findCategoryByName(String name) {
        return categoryAttributeRepository.findByAttributeName(name);
    }
}
