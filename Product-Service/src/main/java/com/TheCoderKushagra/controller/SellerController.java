package com.TheCoderKushagra.controller;

import com.TheCoderKushagra.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<String> callSaveBrand() {

        return new ResponseEntity<>("response", HttpStatus.OK);
    }

    // create products then add inside brand {update brand + create product}

}
