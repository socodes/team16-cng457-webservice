package com.example.webservice.controller;

import com.example.webservice.entity.Brand;
import com.example.webservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/addbrand")
    public  Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }
}
