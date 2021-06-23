package com.example.webservice.controller;

import com.example.webservice.entity.AdditionalFeatures;
import com.example.webservice.entity.Computer;
import com.example.webservice.service.AdditionalFeaturesService;
import com.example.webservice.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;
    @Autowired
    AdditionalFeaturesService additionalFeaturesService;

    Lock lock = new ReentrantLock();
    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c) throws InterruptedException {
        lock.lock();
        //Thread.sleep(10000); //For testing lock, you can add this line.
        Computer cm =  computerService.saveComputer(c);
        lock.unlock();
        return cm;
    }

    @GetMapping("/getcomputeralldetails")
    public List<Computer> getComputerDetails(){

        lock.lock();
        List<Computer> list =  computerService.getComputerDetails();
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable int id){
        lock.lock();
        Computer list = computerService.getComputer(id);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbyscreenresolution/{screenResolution}")
    public List<Computer> getComputerByScreenResolution(@PathVariable String screenResolution){
        lock.lock();
        List<Computer> list = computerService.getComputerByScreenResolution(screenResolution);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbystoragecapacity/{storageCapacity}")
    public List<Computer> getComputerByStorageCapacity(@PathVariable String storageCapacity){
        lock.lock();
        List<Computer> list = computerService.getComputerByStorageCapacity(storageCapacity);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbymemory/{memory}")
    public List<Computer> getComputerByMemory(@PathVariable String memory){
        lock.lock();
        List<Computer> list = computerService.getComputerByMemory(memory);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbyprocessor/{processor}")
    public List<Computer> getComputerByProcessor(@PathVariable String processor){
        lock.lock();
        List<Computer> list = computerService.getComputerByProcessor(processor);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbymodel/{model}")
    public List<Computer> getComputerByModel(@PathVariable String model){
        lock.lock();
        List<Computer> list = computerService.getComputerByModel(model);
        lock.unlock();
        return  list;
    }

    @GetMapping("/getcomputersbyprice/{price}")
    public List<Computer> getComputerByPrice(@PathVariable int price){
        lock.lock();
        List<Computer> list = computerService.getComputerByPrice(price);
        lock.unlock();
        return list;
    }

    // Redundant, but keep it for GUI, it might be useful
    @GetMapping("/getcomputersbylabel/{label}")
    public List<Computer> getComputerByLabel(@PathVariable String label){
        lock.lock();
        List<Computer> list = computerService.getComputerByLabel(label);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbyscreensize/{screensize}")
    public List<Computer> getComputerByScreensize(@PathVariable int screensize){
        lock.lock();
        List<Computer> list = computerService.getComputerByScreensize(screensize);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbybrand/{brand_name}")
    public List<Computer> getComputersByBrand(@PathVariable String brand_name){
        lock.lock();
        List<Computer> list = computerService.getComputersByBrand(brand_name);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbycomment/{comment}")
    public List<Computer> getComputersByComment(@PathVariable String comment){
        lock.lock();
        List<Computer> list = computerService.getComputersByComment(comment);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbyrate/{rate}")
    public List<Computer> getComputersByRate(@PathVariable int rate){
        lock.lock();
        List<Computer> list = computerService.getComputersByRate(rate);
        lock.unlock();
        return list;
    }

    @GetMapping("/getcomputersbyadditionalfeature/{additionalfeature}")
    public List<Computer> getComputersByAdditionalFeature(@PathVariable String additionalfeature){
        lock.lock();
        List<Computer> list = computerService.getComputersByAdditionalFeature(additionalfeature);
        lock.unlock();
        return list;
    }

    @GetMapping("/updateComputer/addAdditionalFeatures/{computerID}/{afId}")
    public Computer updateComputer(@PathVariable int computerID, @PathVariable int afId){
        lock.lock();
        Computer tempComputer = computerService.getComputer(computerID);
        AdditionalFeatures additionalFeatures = additionalFeaturesService.getAdditionalFeatures(afId);
        tempComputer.getAdditionalFeaturesList().add(additionalFeatures);
        Computer cm = computerService.saveComputer(tempComputer);
        lock.unlock();
        return cm;

    }

    @GetMapping("/updateComputer/label/{computerID}/{label}")
    public Computer updateComputerLabel(@PathVariable int computerID, @PathVariable String label){
        lock.lock();
        Computer tempComputer = computerService.getComputer(computerID);
        tempComputer.setLabel(label);
        Computer cm =  computerService.saveComputer(tempComputer);
        lock.unlock();
        return cm;
    }

    @GetMapping("/getcomputersbysearch")
    public List<Computer> getPhonesBySearch(@RequestParam(required = false) Integer product_id,
                                            @RequestParam(required = false) String model,
                                            @RequestParam(required = false) String model1,
                                            @RequestParam(required = false) String model2,
                                            @RequestParam(required = false) Integer price,
                                            @RequestParam(required = false) String label,
                                            @RequestParam(required = false) Integer screensize,
                                            @RequestParam(required = false) String screen_resolution,
                                            @RequestParam(required = false) String storage_capacity,
                                            @RequestParam(required = false) String memory,
                                            @RequestParam(required = false) String processor,
                                            @RequestParam(required = false) Integer minprice,
                                            @RequestParam(required = false) Integer maxprice,
                                            @RequestParam(required = false) Integer minscreensize,
                                            @RequestParam(required = false) Integer maxscreensize,
                                            @RequestParam(required = false) String afs_name,
                                            @RequestParam(required = false) String comment,
                                            @RequestParam(required = false) Integer rate,
                                            @RequestParam(required = false) String brand_name) {
        lock.lock();
        List<Computer> computerList = computerService.getComputerDetails();

        if (product_id != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getProduct_id() != product_id) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if(model != null){
            for(int i = 0; i < computerList.size(); i++){
                Computer currentComputer = computerList.get(i);
                if (!currentComputer.getModel().equals(model)) {
                    computerList.remove(i);
                    i--;
                }
            }

        }

        if (model1 != null && model2 != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (!currentComputer.getModel().equals(model1) && !currentComputer.getModel().equals(model2)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (price != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getPrice() != price) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (label != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (!currentComputer.getLabel().contains(label)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (screensize != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getScreensize() != screensize) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (screen_resolution != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (!currentComputer.getScreenResolution().equals(screen_resolution)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (storage_capacity != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (!currentComputer.getStorageCapacity().equals(storage_capacity)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (memory != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (!currentComputer.getMemory().equals(memory)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (processor != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (!currentComputer.getProcessor().equals(processor)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (minprice != null && maxprice != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if ((maxprice < currentComputer.getPrice()) || (currentComputer.getPrice() < minprice)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (minscreensize != null && maxscreensize != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if ((maxscreensize < currentComputer.getScreensize()) || (currentComputer.getScreensize() < minscreensize)) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (afs_name != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                for(int j = 0; j < currentComputer.getAdditionalFeaturesList().size(); j++){
                    if(!currentComputer.getAdditionalFeaturesList().get(j).getAfs_name().contains(afs_name)){
                        currentComputer.getAdditionalFeaturesList().remove(j);
                        j--;
                    }
                }
                if (currentComputer.getAdditionalFeaturesList().size() == 0) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (comment != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                for(int j = 0; j < currentComputer.getCommentAndRatesList().size(); j++){
                    if(!currentComputer.getCommentAndRatesList().get(j).getComment().contains(comment)){
                        currentComputer.getCommentAndRatesList().remove(j);
                        j--;
                    }
                }
                if (currentComputer.getCommentAndRatesList().size() == 0) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (brand_name != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                for(int j = 0; j < currentComputer.getBrandList().size(); j++){
                    if(!currentComputer.getBrandList().get(j).getBrand_name().equals(brand_name)){
                        currentComputer.getBrandList().remove(j);
                        j--;
                    }
                }
                if (currentComputer.getBrandList().size() == 0) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (rate != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                for(int j = 0; j < currentComputer.getCommentAndRatesList().size(); j++){
                    if (currentComputer.getCommentAndRatesList().get(j).getRate() != rate) {
                        currentComputer.getCommentAndRatesList().remove(j);
                        j--;
                    }
                }
                if(currentComputer.getCommentAndRatesList().size() == 0){
                    computerList.remove(i);
                    i--;
                }
            }
        }
        lock.unlock();
        return computerList;
    }

}
