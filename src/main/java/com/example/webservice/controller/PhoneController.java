package com.example.webservice.controller;

import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getphonealldetails")
    public List<Phone> getPhoneDetails(){
        return phoneService.getPhoneDetails();
    }

    @GetMapping("/getphonesbybrand/{name}")
    public List<Phone> getPhonesFromBrand(@PathVariable String name){
        return phoneService.getPhonesFromBrand(name);
    }

    @GetMapping("/getphonesbyinternalmemory/{internalmemory}")
    public List<Phone> getPhonesByInternalMemory(@PathVariable String internalMemory){
        return phoneService.getPhonesByInternalMemory(internalMemory);
    }

    @GetMapping("/getphonesbybrandandid/{name}/{id}")
    public List<Phone> getPhonesFromBrandandID(@PathVariable String name,@PathVariable int id){
        return phoneService.getPhonesFromBrandandID(name,id);
    }


}
