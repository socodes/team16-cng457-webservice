package com.example.webservice.controller;

import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @PostMapping("/addphone")
    public Product savePhone(@RequestBody Phone p){
        return phoneService.savePhone(p);
    }

    @GetMapping("/getphone/{id}")
    public Product getPhone(@PathVariable int id){
        return phoneService.getPhone(id);
    }
<<<<<<< Updated upstream
=======

    @GetMapping("/getphonealldetails")
    public List<Phone> getPhoneDetails(){
        return phoneService.getPhoneDetails();
    }


    @GetMapping("/getphonesbybrand/{name}")
    public List<Phone> getPhonesFromBrand(@PathVariable String name){
        return phoneService.getPhonesFromBrand(name);
    }



>>>>>>> Stashed changes
}
