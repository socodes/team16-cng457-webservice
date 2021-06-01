package com.example.webservice.controller;

import com.example.webservice.entity.Brand;
import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Product;
import com.example.webservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/addbrand")
    public  Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    @GetMapping("/getbrand/{id}")
    public Brand getComputer(@PathVariable int id){
        return brandService.getBrand(id);
    }

    @GetMapping("/getbrandalldetails")
    public List<Brand> getComputerDetails(){
        return brandService.getBrandDetails();
    }

}
