package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.dto.CategoryAttributeRequest;
import com.TheCoderKushagra.entity.Category;

import com.TheCoderKushagra.entity.CategoryAttribute;
import com.TheCoderKushagra.service.CategoryAttributeService;
import com.TheCoderKushagra.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryAttributeService categoryAttributeService;


    @PostMapping("/createCategory")
    private ResponseEntity<Category> callSaveCategory(@RequestBody Category category) {
        Category category1 = categoryService.saveCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @PostMapping("/categoryAttribute")
    public ResponseEntity<?> callSaveCategoryAttribute(@RequestBody CategoryAttributeRequest attribute) {
        CategoryAttribute categoryAttribute = categoryAttributeService.saveCategoryAttribute(attribute);
        return new ResponseEntity<>(categoryAttribute,HttpStatus.OK);
    }
}
