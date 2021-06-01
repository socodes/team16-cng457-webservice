package com.example.webservice.service;

import com.example.webservice.entity.Brand;
import com.example.webservice.entity.Computer;
import com.example.webservice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public Brand saveBrand (Brand b)
    {
        return brandRepository.save(b);
    }


    public Brand getBrand(int id)
    {
        return brandRepository.findById(id).orElse(null);
    }

    public List<Brand> getBrandDetails(){
        return brandRepository.getBrandDetails();
    }
}
