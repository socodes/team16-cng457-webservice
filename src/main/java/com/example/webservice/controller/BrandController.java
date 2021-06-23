/**
 * Importing required documents
 */
package com.example.webservice.controller;
import com.example.webservice.entity.Brand;
import com.example.webservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller method for brand
 */
@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    /**
     * This query saves all attributes of the brand to database
     * @param brand name of the entity
     * @return the brand entity that will be saved to the service
     */
    @PostMapping("/addbrand")
    public Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    /**
     * This query gets all the attributes of the brand object by id from the database and saves as a list
     * @param id primary key of brand (generated automatically)
     * @return the brand list from service by id
     */
    @GetMapping("/getbrand/{id}")
    public Brand getBrand(@PathVariable int id){ return brandService.getBrand(id); }

    /**
     * This query gets all the attributes of the brand object from the database and saves as a list
     * @return list of all attributes of the brand entity which are brand id and brand name
     */
    @GetMapping("/getbrandalldetails")
    public List<Brand> getBrandDetails(){
        return brandService.getBrandDetails();
    }

    /**
     * This query gets all the attributes of the brand object by name from the database and saves as a list
     * @param name an attribute in brand
     * @return the brand list from service by name
     */
    @GetMapping("/getbrandbyname/{name}")
    public List<Brand> getBrandByName(@PathVariable String name){
        return brandService.getBrandByName(name);
    }

}
