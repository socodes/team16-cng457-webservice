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

    public Computer saveComputer(Computer c){ return computerRepository.save(c); }

    public Computer getComputer(int id)
    {
        return computerRepository.findById(id).orElse(null);
    }

    public List<Computer> getComputerDetails() { return computerRepository.findAll(); }

    public List<Computer> getComputerByScreenResolution(String screenResolution) { return computerRepository.getComputersByScreenResolution(screenResolution); }

    public List<Computer> getComputerByStorageCapacity(String storageCapacity) { return computerRepository.getComputersByStorageCapacity(storageCapacity); }

    public List<Computer> getComputerByMemory(String memory) {
        return computerRepository.getComputersByMemory(memory);
    }

    public List<Computer> getComputerByProcessor(String processor) { return computerRepository.getComputersByProcessor(processor); }

    public List<Computer> getComputerByModel(String model) { return computerRepository.getComputerByModel(model); }

    public List<Computer> getComputerByPrice(int price) { return computerRepository.getComputerByPrice(price); }

    public List<Computer> getComputerByLabel(String label) { return computerRepository.getComputerByLabel(label); }

    public List<Computer> getComputerByScreensize(int screensize) { return computerRepository.getComputerByScreensize(screensize); }

    public List<Computer> getComputersByBrand(String brand_name) { return computerRepository.getComputersByBrand(brand_name); }

    public List<Computer> getComputersByComment(String comment) { return computerRepository.getComputersByComment(comment); }

    public List<Computer> getComputersByRate(int rate) { return computerRepository.getComputersByRate(rate); }

    public List<Computer> getComputersByAdditionalFeature(String additionalfeature) { return computerRepository.getComputersByAdditionalFeature(additionalfeature); }

}
