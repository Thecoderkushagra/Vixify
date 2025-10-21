package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.entity.Brand;
import com.TheCoderKushagra.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> save(@RequestBody Brand brand) {
        Brand saved = brandService.saveBrand(brand);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}
