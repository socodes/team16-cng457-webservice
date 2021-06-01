package com.example.webservice.service;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
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
}
