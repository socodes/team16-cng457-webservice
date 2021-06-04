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

    public List<Computer> getComputerByScreenResolution(String screenresolution) { return computerRepository.getComputersByScreenResolution(screenresolution); }

    public List<Computer> getComputerByStorageCapacity(String storagecapacity) { return computerRepository.getComputersByStorageCapacity(storagecapacity); }

    public List<Computer> getComputerByMemory(String memory) {
        return computerRepository.getComputersByMemory(memory);
    }

    public List<Computer> getComputerByProcessor(String processor) { return computerRepository.getComputersByProcessor(processor); }

    public List<Computer> getComputerByModel(String model) { return computerRepository.getComputerByModel(model); }

    public List<Computer> getComputerByPrice(int price) { return computerRepository.getComputerByPrice(price); }

    public List<Computer> getComputerByLabel(String label) { return computerRepository.getComputerByLabel(label); }

    public List<Computer> getComputerByScreensize(String screensize) { return computerRepository.getComputerByScreensize(screensize); }

    public List<Computer> getComputersByBrand(String name) { return computerRepository.getComputersByBrand(name); }

    public List<Computer> getComputersByComment(String comment) { return computerRepository.getComputersByComment(comment); }

    public List<Computer> getComputersByRate(int rate) { return computerRepository.getComputersByRate(rate); }

    public List<Computer> getComputersByAdditionalFeature(String additionalfeature) { return computerRepository.getComputersByAdditionalFeature(additionalfeature); }

    public List<Computer> getComputersByBrandAndComment(String name, String comment) {
        return computerRepository.getComputersByBrandAndComment(name, comment);
    } //EDA

    public List<Computer> getComputersByBrandAndRate(String name, int rate) {
        return  computerRepository.getComputersByBrandAndRate(name, rate);
    } //EDA

    public List<Computer> getComputersByAdditionalFeatureAndComment(String additionalfeature, String comment) {
        return  computerRepository.getComputersByAdditionalFeatureAndComment(additionalfeature, comment);
    } //EDA

    public List<Computer> getComputersByAdditionalFeatureAndRate(String additionalfeature, int rate) {
        return  computerRepository.getComputersByAdditionalFeatureAndRate(additionalfeature, rate);
    } //EDA

    public List<Computer> getComputersByAdditionalFeatureAndBrand(String additionalfeature, String name) {
        return  computerRepository.getComputersByAdditionalFeatureAndBrand(additionalfeature, name);
    }

    public List<Computer> getComputersByLabelAndPrice(String label, int price) {
        return  computerRepository.getComputersByLabelAndPrice(label, price);
    }

    public List<Computer> getComputersByLabelAndScreensize(String label, String screensize) {
        return  computerRepository.getComputersByLabelAndScreensize(label, screensize);
    }

    public List<Computer> getComputersByLabelAndModel(String label, String model) {
        return  computerRepository.getComputersByLabelAndSModel(label, model);
    }

    /*
    public List<Computer> getComputerFromBrandAndID(String name, int id){
        return computerRepository.getComputersFromBrandAndID(name, id);
    }

     */


}
