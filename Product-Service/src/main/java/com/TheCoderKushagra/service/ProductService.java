package com.TheCoderKushagra.service;

import com.TheCoderKushagra.repository.ProductAttributeIndexRepository;
import com.TheCoderKushagra.repository.ProductAttributeRepository;
import com.TheCoderKushagra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductAttributeRepository AttributeRepository;
    @Autowired
    private ProductAttributeIndexRepository AttributeIndexRepository;

}
