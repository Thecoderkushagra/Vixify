package com.TheCoderKushagra.service;

import com.TheCoderKushagra.entity.Brand;
import com.TheCoderKushagra.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand createBrand(String brandName) {
        Brand build = Brand.builder().name(brandName).build();
        return brandRepository.save(build);
    }
}
