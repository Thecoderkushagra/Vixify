package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.dto.CategoryAttributeRequest;
import com.TheCoderKushagra.dto.CategoryAttributeResponse;
import com.TheCoderKushagra.dto.CategoryRequest;
import com.TheCoderKushagra.dto.CategoryResponse;
import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create-category")
    public ResponseEntity<CategoryResponse> callCreateCategory(@RequestBody CategoryRequest request) {
        CategoryResponse category = categoryService.createCategory(request);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/see-categories")
    public ResponseEntity<List<CategoryResponse>> callSeeAllCategory() {
        List<CategoryResponse> categories = categoryService.seeAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/update-category/{categoryId}")
    public ResponseEntity<CategoryResponse> callUpdateCategory(
            @PathVariable String categoryId,
            @RequestBody CategoryRequest request
    ){
        CategoryResponse categoryResponse = categoryService.upgradeCategory(categoryId, request);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("createCategoryAttribute")
    public ResponseEntity<CategoryAttributeResponse> callCreateCategoryAttribute(
            @RequestBody CategoryAttributeRequest request) {
        CategoryAttributeResponse categoryAttribute = categoryService.createCategoryAttribute(request);
        return new ResponseEntity<>(categoryAttribute, HttpStatus.OK);
    }

    @DeleteMapping("/delete-categoryAttribute/{attributeId}")
    public ResponseEntity<?> deleteCategoryAttribute(@PathVariable String attributeId) {
        categoryService.DeleteCategoryAttribute(attributeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
