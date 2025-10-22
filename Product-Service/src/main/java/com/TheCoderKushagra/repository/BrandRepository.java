package com.TheCoderKushagra.repository;

import com.TheCoderKushagra.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    Brand findByName(String name);
}
