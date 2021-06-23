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

    // These are redundant for testing since we only want Phone or Computer but we kept them just in case.

    /**
     * This query saves all attributes of the product to database
     * @param p name of the entity
     * @return save the phone list to service
     */
    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product p){
        return productService.saveProduct(p);
    }

    /**
     * This query gets all the attributes of the products object from the database and saves as a list
     * @return get all attributes of the product entity which are product id, model, price, label, screensize
     */
    @GetMapping("/getproductalldetails")
    public List<Product> getProductDetails(){
        return productService.getProductDetails();
    }

    /**
     * This query gets all the attributes of the products object by id from the database and saves as a list
     * @param id primary key of computer (generated automatically)
     * @return get the product list from service by id
     */
    @GetMapping("/getproduct/{id}")
    public Product getProduct(@PathVariable  int id){
        return productService.getProduct(id);
    }

}
