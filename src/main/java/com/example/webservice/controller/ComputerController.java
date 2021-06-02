package com.example.webservice.controller;

import com.example.webservice.entity.Computer;
import com.example.webservice.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c){
        return computerService.saveComputer(c);
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable int id){
        return computerService.getComputer(id);
    }

    @GetMapping("/getcomputeralldetails")
    public List<Computer> getComputerDetails(){
        return computerService.getComputerDetails();
    }

    @GetMapping("/getcomputersbybrand/{name}")
    public List<Computer> getComputerFromBrand(@PathVariable String name){
        return computerService.getComputerFromBrand(name);
    }

    @GetMapping("/getphonesbybrandandid/{name}/{id}")
    public List<Computer> getPhonesFromBrandandID(@PathVariable String name,@PathVariable int id){
        return computerService.getComputerFromBrandandID(name,id);
    }
}
