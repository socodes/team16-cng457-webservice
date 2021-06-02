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

    @GetMapping("/getadditionalfeatures/{id}")
    public AdditionalFeatures getAdditionalFeatures(@PathVariable int id){
        return AdditionalFeaturesService.getAdditionalFeatures(id);
    }

    @GetMapping("/getadditionalfeaturesalldetails")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails(){
        return AdditionalFeaturesService.getAdditionalFeaturesDetails();
    }

    @GetMapping("/getadditionalfeaturestouchscreen")
    public List<AdditionalFeatures> getAdditionalFeaturesTouchscreen(){
        return AdditionalFeaturesService.getAdditionalFeaturesTouchscreen();
    }
    @GetMapping("/getadditionalfeaturesfacerecognition")
    public List<AdditionalFeatures> getAdditionalFeaturesFaceRecognition(){
        return AdditionalFeaturesService.getAdditionalFeaturesFaceRecognition();
    }
    @GetMapping("/getadditionalfeaturesfingerprintreader")
    public List<AdditionalFeatures> getAdditionalFeaturesFingerprintReader(){
        return AdditionalFeaturesService.getAdditionalFeaturesFingerprintReader();
    }

    @GetMapping("/getadditionalfeaturesextralongbatterylife")
    public List<AdditionalFeatures> getAdditionalFeaturesExtraLongBatteryLife(){
        return AdditionalFeaturesService.getAdditionalFeaturesExtraLongBatteryLife();
    }
}
