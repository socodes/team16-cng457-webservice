package com.example.webservice.controller;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import com.example.webservice.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c){ return computerService.saveComputer(c); }

    @GetMapping("/getcomputeralldetails")
    public List<Computer> getComputerDetails(){
        return computerService.getComputerDetails();
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable int id){
        return computerService.getComputer(id);
    }

    @GetMapping("/getcomputersbyscreenresolution/{screenresolution}")
    public List<Computer> getComputerByScreenResolution(@PathVariable String screenresolution){
        return computerService.getComputerByScreenResolution(screenresolution);
    }

    @GetMapping("/getcomputersbystoragecapacity/{storagecapacity}")
    public List<Computer> getComputerByStorageCapacity(@PathVariable String storagecapacity){
        return computerService.getComputerByStorageCapacity(storagecapacity);
    }

    @GetMapping("/getcomputersbymemory/{memory}")
    public List<Computer> getComputerByMemory(@PathVariable String memory){
        return computerService.getComputerByMemory(memory);
    }

    @GetMapping("/getcomputersbyprocessor/{processor}")
    public List<Computer> getComputerByProcessor(@PathVariable String processor){
        return computerService.getComputerByProcessor(processor);
    }

    /*
    @GetMapping("/getcomputersbybrandandid/{name}/{id}")
    public List<Computer> getComputersFromBrandAndID(@PathVariable String name,@PathVariable int id){
        return computerService.getComputerFromBrandAndID(name, id);
    }
    */

    @GetMapping("/getcomputersbymodel/{model}")
    public List<Computer> getComputerByModel(@PathVariable String model){
        return computerService.getComputerByModel(model);
    }

    @GetMapping("/getcomputersbyprice/{price}")
    public List<Computer> getComputerByPrice(@PathVariable int price){
        return computerService.getComputerByPrice(price);
    }

    @GetMapping("/getcomputersbylabel/{label}")
    public List<Computer> getComputerByLabel(@PathVariable String label){
        return computerService.getComputerByLabel(label);
    }

    @GetMapping("/getcomputersbyscreensize/{screensize}")
    public List<Computer> getComputerByScreensize(@PathVariable String screensize){
        return computerService.getComputerByScreensize(screensize);
    }

    @GetMapping("/getcomputersbybrand/{brand}")
    public List<Computer> getComputersByBrand(@PathVariable String name){
        return computerService.getComputersByBrand(name);
    }

    @GetMapping("/getcomputersbycomment/{comment}")
    public List<Computer> getComputersByComment(@PathVariable String comment){
        return computerService.getComputersByComment(comment);
    }

    @GetMapping("/getcomputersbyrate/{rate}")
    public List<Computer> getComputersByRate(@PathVariable int rate){
        return computerService.getComputersByRate(rate);
    }

    @GetMapping("/getcomputersbyadditionalfeature/{additionalfeature}")
    public List<Computer> getComputersByAdditionalFeature(@PathVariable String additionalfeature){
        return computerService.getComputersByAdditionalFeature(additionalfeature);
    }

    @GetMapping("/getcomputersbybrandandcomment/{name}/{comment}") //EDA
    public List<Computer> getComputersByBrandAndComment(@PathVariable String name, @PathVariable String comment){
        return computerService.getComputersByBrandAndComment(name,comment);
    }

    @GetMapping("/getcomputersbybrandandrate/{name}/{rate}") //EDA
    public List<Computer> getComputersByBrandAndRate(@PathVariable String name, @PathVariable int rate){
        return computerService.getComputersByBrandAndRate(name, rate);
    }

    @GetMapping("/getcomputersbyadditionalfeatureandcomment/{additionalfeature}/{comment}") //EDA
    public List<Computer> getComputersByAdditionalFeatureAndComment(@PathVariable String additionalfeature, @PathVariable String comment){
        return computerService.getComputersByAdditionalFeatureAndComment(additionalfeature, comment);
    }

    @GetMapping("/getcomputersbyadditionalfeatureandrate/{additionalfeature}/{rate}") //EDA
    public List<Computer> getComputersByAdditionalFeatureAndRate(@PathVariable String additionalfeature, @PathVariable int rate){
        return computerService.getComputersByAdditionalFeatureAndRate(additionalfeature, rate);
    }

    @GetMapping("/getcomputersbyadditionalfeatureandbrand/{additionalfeature}/{name}") //EDA
    public List<Computer> getComputersByAdditionalFeatureAndBrand(@PathVariable String additionalfeature, @PathVariable String name){
        return computerService.getComputersByAdditionalFeatureAndBrand(additionalfeature, name);
    }

    @GetMapping("/getcomputersbylabelandprice/{label}/{price}") //Muhammed
    public List<Computer> getPhonesByLabelAndPrice(@PathVariable String label, @PathVariable int price){
        return computerService.getComputersByLabelAndPrice(label, price);
    }
    @GetMapping("/getcomputersbylabelandscreensize/{label}/{screensize}") //Muhammed
    public List<Computer> getPhonesByLabelAndScreensize(@PathVariable String label, @PathVariable String screensize){
        return computerService.getComputersByLabelAndScreensize(label, screensize);
    }
    @GetMapping("/getcomputersbylabelandmodel/{label}/{model}") //Muhammed
    public List<Computer> getPhonesByLabelAndModel(@PathVariable String label, @PathVariable String model){
        return computerService.getComputersByLabelAndModel(label, model);
    }

}
