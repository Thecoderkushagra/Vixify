package com.TheCoderKushagra.service;

import com.TheCoderKushagra.dto.ProductRequest;
import com.TheCoderKushagra.entity.Brand;
import com.TheCoderKushagra.entity.Category;
import com.TheCoderKushagra.entity.Product;
import com.TheCoderKushagra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;

    public Product saveProduct(ProductRequest product) {
        Brand brandByName = brandService.findBrandByName(product.getBrand());
        Category categoryByName = categoryService.findCategoryByName(product.getCategory());

        Product mainProduct = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .basePrice(product.getBasePrice())
                .brand(brandByName)
                .category(categoryByName)
                .createdAt(LocalDateTime.now())
                .build();
        brandByName.getProducts().add(mainProduct);
        return productRepository.save(mainProduct);
    }
}
