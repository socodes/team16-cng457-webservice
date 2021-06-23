package com.example.webservice.controller;

import com.example.webservice.entity.Brand;
import com.example.webservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    /**
     * This query saves all attributes of the brand to database
     * @param brand name of the entity
     * @return save the brand list to service
     */
    @PostMapping("/addbrand")
    public Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    /**
     * This query gets all the attributes of the brand object by id from the database and saves as a list
     * @param id primary key of brand (generated automatically)
     * @return get the brand list from service by id
     */
    @GetMapping("/getbrand/{id}")
    public Brand getBrand(@PathVariable int id){ return brandService.getBrand(id); }

    /**
     * This query gets all the attributes of the brand object from the database and saves as a list
     * @return get all attributes of the brand entity which are brand id and brand name
     */
    @GetMapping("/getbrandalldetails")
    public List<Brand> getBrandDetails(){
        return brandService.getBrandDetails();
    }

    /**
     * This query gets all the attributes of the brand object by name from the database and saves as a list
     * @param name an attribute in additional feature
     * @return get the additional feature list from service by name
     */
    @GetMapping("/getbrandbyname/{name}")
    public List<Brand> getBrandByName(@PathVariable String name){
        return brandService.getBrandByName(name);
    }

}
