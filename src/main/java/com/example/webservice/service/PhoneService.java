package com.example.webservice.service;

import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.repository.PhoneRepository;
import com.example.webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
<<<<<<< Updated upstream
=======

    public List<Phone> getPhoneDetails(){
        return phoneRepository.getPhoneDetails();
    }

    public List<Phone> getPhonesFromBrand(String name){
        return phoneRepository.findByBrandList(name);
    }


>>>>>>> Stashed changes
}
