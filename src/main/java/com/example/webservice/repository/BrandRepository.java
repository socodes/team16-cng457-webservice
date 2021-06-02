package com.example.webservice.repository;

import com.example.webservice.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface BrandRepository extends JpaRepository<Brand, Integer>{
    @Query("SELECT b FROM Brand b")
    public List<Brand> getBrandDetails();
}
