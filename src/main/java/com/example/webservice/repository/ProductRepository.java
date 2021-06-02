package com.example.webservice.repository;


import com.example.webservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p INNER JOIN Brand b ON p.product_id = b.brand_id")
    public List<Product> getProductDetails();

    /*
    @Query("SELECT p FROM Product p WHERE model LIKE %?1%")
    List<Product> getProductByModel(String model);

    @Query("SELECT p FROM Product p WHERE price LIKE %?1%")
    List<Product> getProductByPrice(int price);


    @Query("SELECT p FROM Product p WHERE label LIKE %?1%")
    List<Product> getProductByLabel(String label);

    @Query("SELECT p FROM Product p WHERE screensize LIKE %?1%")
    List<Product> getProductByScreensize(String screensize);
    */
}
