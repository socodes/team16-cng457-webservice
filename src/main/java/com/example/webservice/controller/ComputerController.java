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

    @GetMapping("/getcomputeralldetails")
    public List<Computer> getComputerDetails(){
        return computerService.getComputerDetails();
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable int id){
        return computerService.getComputer(id);
    }

    @GetMapping("/getcomputersbybrandandid/{name}/{id}")
    public List<Computer> getComputersFromBrandandID(@PathVariable String name,@PathVariable int id){
        return computerService.getComputerFromBrandandID(name,id);
    }


    @GetMapping("/getcomputersbybrand/{name}")
    public List<Computer> getComputerFromBrand(@PathVariable String name){
        return computerService.getComputerFromBrand(name);
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

    private String Processor;
*/

}
