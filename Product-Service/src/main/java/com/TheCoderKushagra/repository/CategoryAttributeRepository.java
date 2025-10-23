package com.TheCoderKushagra.repository;

import com.TheCoderKushagra.entity.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute, String> {
    CategoryAttribute findByAttributeName(String name);
}
