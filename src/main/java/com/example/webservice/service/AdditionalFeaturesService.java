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

    public AdditionalFeatures getAdditionalFeatures(int id)
    {
        return AdditionalFeaturesRepository.findById(id).orElse(null);
    }
    public List<AdditionalFeatures> getAdditionalFeaturesDetails(){
        return AdditionalFeaturesRepository.getAdditionalFeaturesDetails();
    }

    public List<AdditionalFeatures> getAdditionalFeaturesTouchscreen(){
        return AdditionalFeaturesRepository.getAdditionalFeaturesTouchscreen();
    }

    public List<AdditionalFeatures> getAdditionalFeaturesFaceRecognition(){
        return AdditionalFeaturesRepository.getAdditionalFeaturesFaceRecognition();
    }

    public List<AdditionalFeatures> getAdditionalFeaturesFingerprintReader(){
        return AdditionalFeaturesRepository.getAdditionalFeaturesFingerprintReader();
    }
    public List<AdditionalFeatures> getAdditionalFeaturesExtraLongBatteryLife(){
        return AdditionalFeaturesRepository.getAdditionalFeaturesExtraLongBatteryLife();
    }
}
