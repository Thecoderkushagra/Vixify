package com.TheCoderKushagra.repository;

import com.TheCoderKushagra.entity.ProductAttributeIndex;
import com.TheCoderKushagra.entity.keys.ProductAttributeIndexKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeIndexRepository extends JpaRepository<ProductAttributeIndex, ProductAttributeIndexKey> {

}
