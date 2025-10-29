package com.TheCoderKushagra.service;

import com.TheCoderKushagra.dto.CategoryAttributeRequest;
import com.TheCoderKushagra.dto.CategoryAttributeResponse;
import com.TheCoderKushagra.dto.CategoryRequest;
import com.TheCoderKushagra.dto.CategoryResponse;
import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.entity.CategoryAttribute;
import com.TheCoderKushagra.repository.CategoryAttributeRepository;
import com.TheCoderKushagra.repository.CategoryRepository;
import com.TheCoderKushagra.repository.ProductAttributeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryAttributeRepository categoryAttributeRepository;
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    public CategoryResponse createCategory(CategoryRequest request) {
        Category myCategoryName = categoryRepository.findByCategoryName(request.getParentCategory());
        Category category = Category.builder()
                .categoryName(request.getCategoryName())
                .parentCategory(myCategoryName)
                .build();
        Category saved = categoryRepository.save(category);
        return CategoryResponse.builder()
                .categoryId(saved.getCategoryId())
                .categoryName(saved.getCategoryName())
                .parentCategory(saved.getParentCategory())
                .attributes(saved.getAttributes())
                .build();
    }

    public List<Category> seeAllCategory() {
        return categoryRepository.findAll();
    }

    public CategoryResponse upgradeCategory(String Id, CategoryRequest request) {
        Category myCategoryName = categoryRepository.findByCategoryName(request.getParentCategory());
        Category category = categoryRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException(Id + "is invalid!!"));

        category.setCategoryName(request.getCategoryName());
        category.setParentCategory(myCategoryName);

        Category saved = categoryRepository.save(category);
        return CategoryResponse.builder()
                .categoryId(saved.getCategoryId())
                .categoryName(saved.getCategoryName())
                .parentCategory(saved.getParentCategory())
                .attributes(saved.getAttributes())
                .build();
    }

    public CategoryAttributeResponse createCategoryAttribute(CategoryAttributeRequest request) {
        Category myCategoryName = categoryRepository.findByCategoryName(request.getCategory());
        CategoryAttribute attribute = CategoryAttribute.builder()
                .category(myCategoryName)
                .attributeName(request.getAttributeName())
                .isRequired(request.getIsRequired())
                .build();
        CategoryAttribute saved = categoryAttributeRepository.save(attribute);
        myCategoryName.getAttributes().add(saved);
        return CategoryAttributeResponse.builder()
                .attributeId(saved.getAttributeId())
                .category(saved.getCategory())
                .attributeName(saved.getAttributeName())
                .isRequired(saved.getIsRequired())
                .build();
    }

    public void DeleteCategoryAttribute(String id) {
        boolean exists = categoryAttributeRepository.existsById(id);
        if(exists) {
            CategoryAttribute categoryAttribute = categoryAttributeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Entity Don't exist"));
            boolean inUse = productAttributeRepository.existsByAttribute(categoryAttribute);
            if (inUse) {
                log.error("Cannot delete category; Some products is using this attributes");
            } else {
                Category category = categoryAttribute.getCategory();
                category.getAttributes().remove(categoryAttribute); // removed from category List
                categoryAttributeRepository.deleteById(id); // removed from CategoryAttribute Table
            }
        } else { log.error("{} id invalid", id); }
    }

}
