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

    @PostMapping("/addadditionalfeatures")
    public AdditionalFeatures saveAdditionalFeatures(@RequestBody AdditionalFeatures AdditionalFeatures){
        return AdditionalFeaturesService.saveAdditionalFeatures(AdditionalFeatures);
    }

    @GetMapping("/getadditionalfeaturesalldetails")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails(){
        return AdditionalFeaturesService.getAdditionalFeaturesDetails();
    }

    //search: af id
    @GetMapping("/getadditionalfeatures/{id}")
    public AdditionalFeatures getAdditionalFeatures(@PathVariable int id){
        return AdditionalFeaturesService.getAdditionalFeatures(id);
    }

    //search: af name
    @GetMapping("/getadditionalfeaturesallbyname/{name}")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails(@PathVariable String name){
        return AdditionalFeaturesService.getAdditionalFeaturesByName(name);
    }
}
