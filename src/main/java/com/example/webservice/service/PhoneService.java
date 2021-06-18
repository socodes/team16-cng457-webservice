package com.example.webservice.service;

import com.example.webservice.entity.Phone;
import com.example.webservice.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    public Phone savePhone(Phone p){ return phoneRepository.save(p); }

    public Phone getPhone(int id) { return phoneRepository.findById(id).orElse(null); }

    public List<Phone> getPhoneDetails() { return phoneRepository.findAll(); }

    public List<Phone> getPhonesByInternalMemory(String internalMemory) { return phoneRepository.getPhonesByInternalMemory(internalMemory); }
    
    //public List<Phone> getPhonesFromBrandandID(String name,int id){ return phoneRepository.getPhonesFromBrandandID(name,id); }

    public List<Phone> getPhonesByModel(String model) { return phoneRepository.getPhonesByModel(model); }

    public List<Phone> getPhonesByPrice(int price) { return phoneRepository.getPhonesByPrice(price); }

    public List<Phone> getPhonesByLabel(String label) { return phoneRepository.getPhonesByLabel(label); }

    public List<Phone> getPhonesByScreensize(int screensize) { return phoneRepository.getPhonesByScreensize(screensize); }

    public List<Phone> getPhonesByBrand(String name){ return phoneRepository.getPhonesByBrand(name); }

    public List<Phone> getPhonesByComment(String comment) { return phoneRepository.getPhonesByComment(comment); }

    public List<Phone> getPhonesByRate(int rate) { return phoneRepository.getPhonesByRate(rate); }

    public List<Phone> getPhonesByAdditionalFeature(String additionalfeature) { return phoneRepository.getPhonesByAdditionalFeature(additionalfeature); }

}
