package com.example.webservice.service;

import com.example.webservice.entity.Product;
import com.example.webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product p)
    {
        return productRepository.save(p);
    }

    public Product getProduct(int id)
    {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductDetails(){
        return productRepository.getProductDetails();
    }

    public List<Product> getProductByModel(String model) {
        return productRepository.getProductByModel(model);
    }

    public List<Product> getProductByPrice(int price) {
        return productRepository.getProductByPrice(price);
    }

    public List<Product> getProductByLabel(String label) {
        return productRepository.getProductByLabel(label);
    }

    public List<Product> getProductByScreensize(String screensize) {
        return productRepository.getProductByScreensize(screensize);
    }
}
