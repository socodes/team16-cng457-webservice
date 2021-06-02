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

}
