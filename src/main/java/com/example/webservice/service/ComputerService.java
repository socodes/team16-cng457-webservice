package com.example.webservice.service;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Product;
import com.example.webservice.repository.ComputerRepository;
import com.example.webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
