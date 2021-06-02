package com.example.webservice.service;

import com.example.webservice.entity.AdditionalFeatures;
import com.example.webservice.repository.AdditionalFeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalFeaturesService {
    @Autowired
    AdditionalFeaturesRepository AdditionalFeaturesRepository;

    public AdditionalFeatures saveAdditionalFeatures(AdditionalFeatures a)
    {
        return AdditionalFeaturesRepository.save(a);
    }

    public List<AdditionalFeatures> getAdditionalFeaturesDetails(){
        return AdditionalFeaturesRepository.getAdditionalFeaturesDetails();
    }

    public AdditionalFeatures getAdditionalFeatures(int id)
    {
        return AdditionalFeaturesRepository.findById(id).orElse(null);
    }


    public List<AdditionalFeatures> getAdditionalFeaturesByName(String name) {
        return AdditionalFeaturesRepository.getAdditionalFeaturesByName(name);
    }
}
