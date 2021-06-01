package com.example.webservice.service;

import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    public Phone savePhone(Phone p)
    {
        return phoneRepository.save(p);
    }

    public Phone getPhone(int id)
    {
        return phoneRepository.findById(id).orElse(null);
    }

    public List<Phone> getPhoneDetails(){
        return phoneRepository.getPhoneDetails();
    }

    public List<Phone> getPhonesFromBrand(String name){
        return phoneRepository.getPhonesFromBrand(name);
    }


}
