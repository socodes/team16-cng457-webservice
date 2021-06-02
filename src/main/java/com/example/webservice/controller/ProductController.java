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

    @GetMapping("/getproductalldetails")
    public List<Product> getProductDetails(){
        return productService.getProductDetails();
    }

    @GetMapping("/getproduct/{id}")
    public Product getProduct(@PathVariable  int id){
        return productService.getProduct(id);
    }


    @GetMapping("/getproductbymodel/{model}")
    public List<Product> getProductByModel(@PathVariable String model){
        return productService.getProductByModel(model);
    }

    @GetMapping("/getproductbyprice/{price}")
    public List<Product> getProductByPrice(@PathVariable int price){
        return productService.getProductByPrice(price);
    }

    @GetMapping("/getproductbylabel/{label}")
    public List<Product> getProductByLabel(@PathVariable String label){
        return productService.getProductByLabel(label);
    }

    @GetMapping("/getproductbyscreensize/{screensize}")
    public List<Product> getProductByScreensize(@PathVariable String screensize){
        return productService.getProductByScreensize(screensize);
    }


}
