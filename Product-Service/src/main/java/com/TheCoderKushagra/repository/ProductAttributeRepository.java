package com.TheCoderKushagra.repository;

import com.TheCoderKushagra.entity.ProductAttribute;
import com.TheCoderKushagra.entity.keys.ProductAttributeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, ProductAttributeKey> {

}
