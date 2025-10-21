package com.TheCoderKushagra.service;

import com.TheCoderKushagra.entity.Brand;
import com.TheCoderKushagra.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> findAllBrand(Brand brand) {
        return brandRepository.findAll();
    }

    public Brand findBradById(String id){
        return brandRepository.findById(id).orElseThrow(()-> new RuntimeException("INCORRECT ID!!"));
    }

    public String deleteBrand(String id) {
        brandRepository.deleteById(id);
        return "Deleted!!";
    }
}
