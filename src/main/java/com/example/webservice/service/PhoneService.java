package com.example.webservice.service;

import com.example.webservice.entity.Phone;
import com.example.webservice.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;
    Lock lock = new ReentrantLock();

    public Phone savePhone(Phone p) throws InterruptedException {
        lock.lock();
        Thread.sleep(10000); //For testing, you can add this line
        Phone savePhones = phoneRepository.save(p);
        lock.unlock();
        return savePhones;
    }

    public Phone getPhone(int id) throws InterruptedException {
        lock.lock();
        Phone getPhoneByID = phoneRepository.findById(id).orElse(null);
        lock.unlock();
        return getPhoneByID;
    }

    public List<Phone> getPhoneDetails() {
        lock.lock();
        List<Phone> getPhoneAllDetails = phoneRepository.findAll();
        getPhoneAllDetails.add(new Phone());
        lock.unlock();
        return  getPhoneAllDetails;
    }

    public List<Phone> getPhonesByInternalMemory(String internalMemory) {
        lock.lock();
        List<Phone> getPhoneByIntMem = phoneRepository.getPhonesByInternalMemory(internalMemory);
        lock.unlock();
        return getPhoneByIntMem;

    }
    
    //public List<Phone> getPhonesFromBrandandID(String name,int id){ return phoneRepository.getPhonesFromBrandandID(name,id); }

    public List<Phone> getPhonesByModel(String model) {
        lock.unlock();
        List<Phone> getPhoneModel = phoneRepository.getPhonesByModel(model);
        lock.unlock();
        return getPhoneModel;
    }

    public List<Phone> getPhonesByPrice(int price) {
        lock.lock();
        List<Phone> getPhonePrice = phoneRepository.getPhonesByPrice(price);
        lock.unlock();
        return getPhonePrice;
    }

    public List<Phone> getPhonesByLabel(String label) {
        lock.lock();
        List<Phone> getPhoneLabel = phoneRepository.getPhonesByLabel(label);
        lock.unlock();
        return getPhoneLabel;
    }

    public List<Phone> getPhonesByScreensize(int screensize) {
        lock.lock();
        List<Phone> getPhoneScreensize = phoneRepository.getPhonesByScreensize(screensize);
        lock.unlock();
        return getPhoneScreensize;
    }

    public List<Phone> getPhonesByBrand(String name){
        lock.lock();
        List<Phone> getPhoneBrand = phoneRepository.getPhonesByBrand(name);
        lock.unlock();
        return getPhoneBrand;
    }

    public List<Phone> getPhonesByComment(String comment) {
        lock.lock();
        List<Phone> getPhoneComment = phoneRepository.getPhonesByComment(comment);
        lock.unlock();
        return getPhoneComment;
    }

    public List<Phone> getPhonesByRate(int rate) {
        lock.lock();
        List<Phone> getPhoneRate = phoneRepository.getPhonesByRate(rate);
        lock.unlock();
        return getPhoneRate;
    }

    public List<Phone> getPhonesByAdditionalFeature(String additionalfeature) {
        lock.lock();
        List<Phone> getPhoneAddFeature = phoneRepository.getPhonesByAdditionalFeature(additionalfeature);
        lock.unlock();
        return getPhoneAddFeature;
    }

}
