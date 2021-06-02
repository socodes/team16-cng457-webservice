package com.example.webservice.repository;

import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p JOIN Brand b ON p.product_id = b.brand_id AND p.brandList = b.brand_name")
    public List<Product> getProductDetails();
}
