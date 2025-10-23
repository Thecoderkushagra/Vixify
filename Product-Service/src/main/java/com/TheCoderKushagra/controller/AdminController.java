package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    private ResponseEntity<?> callSaveCategory() {

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
