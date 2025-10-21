package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.entity.Brand;
import com.TheCoderKushagra.entity.Product;
import com.TheCoderKushagra.repository.BrandRepository;
import com.TheCoderKushagra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandRepository brandRepository;

    @PostMapping
    private ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Brand byId = brandRepository
                .findById("71cd29e9-5b88-41ed-ad54-aa6861a10644")
                .orElseThrow(() -> new RuntimeException("fucked"));
        product.setBrand(byId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
