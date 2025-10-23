package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.dto.ProductAttributeRequest;
import com.TheCoderKushagra.dto.ProductRequest;
import com.TheCoderKushagra.entity.Brand;
import com.TheCoderKushagra.entity.Product;
import com.TheCoderKushagra.service.BrandService;
import com.TheCoderKushagra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    // MOCK OBJECT (userService.brandName)
    String brandName = "Apple";

    @PostMapping("/createBrand")
    public ResponseEntity<Brand> callSaveBrand() {
        // jwt token to get user
        Brand mybrand = Brand.builder()
                .name(brandName)
                .build();
        Brand saved = brandService.saveBrand(mybrand);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    // create products then add inside brand {update brand + create product}
    @PostMapping("/createProduct")
    public ResponseEntity<Product> callCreateProduct(@RequestBody ProductRequest product) {
        //get user from JWT (brandName-> string) find->Brand
        product.setBrand(brandName);
        Product saved = productService.saveProduct(product);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PostMapping("productAttribute")
    public ResponseEntity<?> callCreateProduct(@RequestBody ProductAttributeRequest attribute) {

        return new ResponseEntity<>("response",HttpStatus.OK);
    }
}
