package com.example.webservice.service;

import com.example.webservice.entity.Computer;
import com.example.webservice.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    public Computer saveComputer(Computer c)
    {
        return computerRepository.save(c);
    }

    public Computer getComputer(int id)
    {
        return computerRepository.findById(id).orElse(null);
    }

    public List<Computer> getComputerDetails(){
        return computerRepository.getComputerDetails();
    }

    public List<Computer> getComputerFromBrand(String name){
        return computerRepository.getComputerFromBrand(name);
    }

    public List<Computer> getComputerFromBrandandID(String name,int id){
        return computerRepository.getComputersFromBrandandID(name,id);
    }

    public List<Computer> getComputerByScreenResolution(String screenresolution) {
        return computerRepository.getComputersByScreenResolution(screenresolution);
    }

    public List<Computer> getComputerByStorageCapacity(String storagecapacity) {
        return computerRepository.getComputersByStorageCapacity(storagecapacity);
    }

    public List<Computer> getComputerByMemory(String memory) {
        return computerRepository.getComputersByMemory(memory);
    }

    public List<Computer> getComputerByProcessor(String processor) {
        return computerRepository.getComputersByProcessor(processor);
    }
}
