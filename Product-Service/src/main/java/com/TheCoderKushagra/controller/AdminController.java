package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.dto.CategoryRequest;
import com.TheCoderKushagra.dto.CategoryResponse;
import com.TheCoderKushagra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create-category")
    public ResponseEntity<?> callCreateCategory(CategoryRequest request) {
        CategoryResponse category = categoryService.createCategory(request);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
