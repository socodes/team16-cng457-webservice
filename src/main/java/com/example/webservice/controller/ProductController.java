/**
 * Importing required documents
 */
package com.example.webservice.controller;
import com.example.webservice.entity.Product;
import com.example.webservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller method for product
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * This query saves all attributes of the product to database
     * @param p Product object
     * @return product object to be saved to the service
     */
    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product p){
        return productService.saveProduct(p);
    }

    /**
     * This query gets all the attributes of the products object from the database and saves as a list
     * @return list of all attributes of the product entit
     */
    @GetMapping("/getproductalldetails")
    public List<Product> getProductDetails(){
        return productService.getProductDetails();
    }

    /**
     * This query gets all the attributes of the products object by id from the database and saves as a list
     * @param id primary key of product (generated automatically)
     * @return the product list from service by id
     */
    @GetMapping("/getproduct/{id}")
    public Product getProduct(@PathVariable  int id){
        return productService.getProduct(id);
    }

}
