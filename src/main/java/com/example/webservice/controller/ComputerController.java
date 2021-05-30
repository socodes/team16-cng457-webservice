package com.example.webservice.controller;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/addcomputer")
    public Product saveComputer(@RequestBody Computer c){
        return computerService.saveComputer(c);
    }

    @GetMapping("/getcomputer/{id}")
    public Product getComputer(@PathVariable int id){
        return computerService.getComputer(id);
    }

    @GetMapping("/getcomputeralldetails")
    public List<Computer> getComputerDetails(){
        return computerService.getComputerDetails();
    }

    @GetMapping("/getcomputersbybrand")
    public List<Computer> getComputerFromBrand(@PathVariable String name){
        return computerService.getComputerFromBrand(name);
    }
}
