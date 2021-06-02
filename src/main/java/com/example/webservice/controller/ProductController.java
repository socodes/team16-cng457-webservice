package com.example.webservice.controller;

import com.example.webservice.entity.Product;
import com.example.webservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product p){
        return productService.saveProduct(p);
    }

    @GetMapping("/getproduct/{id}")
    public Product getProduct(@PathVariable  int id){
        return productService.getProduct(id);
    }

    @GetMapping("/getproductalldetails")
    public List<Product> getProductDetails(){
        return productService.getProductDetails();
    }
}
