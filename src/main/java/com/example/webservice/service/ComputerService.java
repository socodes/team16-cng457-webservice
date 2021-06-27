package com.example.webservice.service;

import com.example.webservice.entity.Computer;
import com.example.webservice.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;
    Lock lock = new ReentrantLock();

    public Computer saveComputer(Computer c) throws InterruptedException {
        lock.lock();
        //Thread.sleep(10000); //For testing, you can add this line
        Computer saveComp = computerRepository.save(c);
        lock.unlock();
        return saveComp;
    }

    public Computer getComputer(int id) {
        lock.lock();
        Computer getCompByID = computerRepository.findById(id).orElse(null);
        lock.unlock();
        return getCompByID;
    }

    public List<Computer> getComputerDetails() {
        lock.lock();
        List<Computer> getCompAllDetails =computerRepository.findAll();
        lock.unlock();
        return getCompAllDetails;
    }

    public List<Computer> getComputerByScreenResolution(String screenResolution) {
        lock.lock();
        List<Computer> getCompByScreenResolution = computerRepository.getComputersByScreenResolution(screenResolution);
        lock.unlock();
        return getCompByScreenResolution;
    }

    public List<Computer> getComputerByStorageCapacity(String storageCapacity) {
        lock.lock();
        List<Computer> getCompByStorageCapacity = computerRepository.getComputersByStorageCapacity(storageCapacity);
        lock.unlock();
        return getCompByStorageCapacity;
    }

    public List<Computer> getComputerByMemory(String memory) {
        lock.lock();
        List<Computer> getCompByMemory = computerRepository.getComputersByMemory(memory);
        lock.unlock();
        return getCompByMemory;
    }

    public List<Computer> getComputerByProcessor(String processor) {
        lock.lock();
        List<Computer> getCompByProcessor = computerRepository.getComputersByProcessor(processor);
        lock.unlock();
        return getCompByProcessor;
    }

    public List<Computer> getComputerByModel(String model) {
        lock.lock();
        List<Computer> getCompByModel = computerRepository.getComputerByModel(model);
        lock.unlock();
        return getCompByModel;
    }

    public List<Computer> getComputerByPrice(int price) {
        lock.lock();
        List<Computer> getCompByPrice = computerRepository.getComputerByPrice(price);
        lock.unlock();
        return getCompByPrice;
    }

    public List<Computer> getComputerByLabel(String label) {
        lock.lock();
        List<Computer> getCompByLabel = computerRepository.getComputerByLabel(label);
        lock.unlock();
        return getCompByLabel;
    }

    public List<Computer> getComputerByScreensize(int screensize) {
        lock.lock();
        List<Computer> getCompByScreensize = computerRepository.getComputerByScreensize(screensize);
        lock.unlock();
        return getCompByScreensize;
    }

    public List<Computer> getComputersByBrand(String brand_name) {
        lock.lock();
        List<Computer> getCompByBrand = computerRepository.getComputersByBrand(brand_name);
        lock.unlock();
        return getCompByBrand;
    }

    public List<Computer> getComputersByComment(String comment) {
        lock.lock();
        List<Computer> getCompByComment = computerRepository.getComputersByComment(comment);
        lock.unlock();
        return getCompByComment;
    }

    public List<Computer> getComputersByRate(int rate) {
        lock.lock();
        List<Computer> getCompByRate = computerRepository.getComputersByRate(rate);
        lock.unlock();
        return getCompByRate;
    }

    public List<Computer> getComputersByAdditionalFeature(String additionalfeature) {
        lock.lock();
        List<Computer> getCompByAddFeature = computerRepository.getComputersByAdditionalFeature(additionalfeature);
        lock.unlock();
        return getCompByAddFeature;
    }

}
