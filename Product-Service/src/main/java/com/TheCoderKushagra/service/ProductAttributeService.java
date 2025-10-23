package com.TheCoderKushagra.service;

import com.TheCoderKushagra.dto.ProductAttributeRequest;
import com.TheCoderKushagra.entity.CategoryAttribute;
import com.TheCoderKushagra.entity.Product;
import com.TheCoderKushagra.entity.ProductAttribute;
import com.TheCoderKushagra.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryAttributeService categoryAttributeService;

    public ProductAttribute saveProductAttribute(ProductAttributeRequest productAttribute) {
        Product productByName = productService.findProductByName(productAttribute.getProduct());
        CategoryAttribute categoryByName = categoryAttributeService.findCategoryByName(productAttribute.getAttribute());

        ProductAttribute myProductAttributes = ProductAttribute.builder()
                .product(productByName)
                .attribute(categoryByName)
                .attributeValue(productAttribute.getAttributeValue())
                .build();
        return productAttributeRepository.save(myProductAttributes);

    }
}
