package com.example.webservice.controller;

import com.example.webservice.entity.AdditionalFeatures;
import com.example.webservice.service.AdditionalFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdditionalFeaturesController {
    @Autowired
    AdditionalFeaturesService AdditionalFeaturesService;

    /**
     * This query saves all attributes of the additional feature to database
     * @param AdditionalFeatures name of the entity
     * @return save the additional feature list to service
     */
    @PostMapping("/addadditionalfeatures")
    public AdditionalFeatures saveAdditionalFeatures(@RequestBody AdditionalFeatures AdditionalFeatures){
        return AdditionalFeaturesService.saveAdditionalFeatures(AdditionalFeatures);
    }

    /**
     * This query gets all the attributes of the additional feature object from the database and saves as a list
     * @return get all attributes of the additional feature entity which are additional feature id and additional feature name
     */
    @GetMapping("/getadditionalfeaturesalldetails")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails(){
        return AdditionalFeaturesService.getAdditionalFeaturesDetails();
    }

    /**
     * This query gets all the attributes of the additional features object by id from the database and saves as a list
     * @param id primary key of additional feature (generated automatically)
     * @return get the additional feature list from service by id
     */
    //search: af id
    @GetMapping("/getadditionalfeatures/{id}")
    public AdditionalFeatures getAdditionalFeatures(@PathVariable int id){
        return AdditionalFeaturesService.getAdditionalFeatures(id);
    }

    /**
     * This query gets all the attributes of the additional features object by name from the database and saves as a list
     * @param name an attribute in additional feature
     * @return get the additional feature list from service by name
     */
    //search: af name
    @GetMapping("/getadditionalfeaturesallbyname/{name}")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails(@PathVariable String name){
        return AdditionalFeaturesService.getAdditionalFeaturesByName(name);
    }
}
