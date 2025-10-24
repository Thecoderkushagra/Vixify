package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.entity.Product;
import com.TheCoderKushagra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viewProducts")
public class UserController {
    @Autowired
    private ProductService productService;

    //right now ->  call for all products
    //update to top 20 products
    @GetMapping
    public ResponseEntity<List<Product>> callSeeProduct() {
        List<Product> products = productService.allProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
