package com.example.webservice.controller;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import com.example.webservice.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c){ return computerService.saveComputer(c); }

    @GetMapping("/getcomputeralldetails")
    public List<Computer> getComputerDetails(){
        return computerService.getComputerDetails();
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable int id){
        return computerService.getComputer(id);
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
    @GetMapping("/getcomputersbybrandandid/{name}/{id}")
    public List<Computer> getComputersFromBrandAndID(@PathVariable String name,@PathVariable int id){
        return computerService.getComputerFromBrandAndID(name, id);
    }
    */

    @GetMapping("/getcomputersbymodel/{model}")
    public List<Computer> getComputerByModel(@PathVariable String model){
        return computerService.getComputerByModel(model);
    }

    @GetMapping("/getcomputersbyprice/{price}")
    public List<Computer> getComputerByPrice(@PathVariable int price){
        return computerService.getComputerByPrice(price);
    }

    @GetMapping("/getcomputersbylabel/{label}")
    public List<Computer> getComputerByLabel(@PathVariable String label){
        return computerService.getComputerByLabel(label);
    }

    @GetMapping("/getcomputersbyscreensize/{screensize}")
    public List<Computer> getComputerByScreensize(@PathVariable String screensize){
        return computerService.getComputerByScreensize(screensize);
    }

    @GetMapping("/getcomputersbybrand/{brand}")
    public List<Computer> getComputersByBrand(@PathVariable String name){
        return computerService.getComputersByBrand(name);
    }

    @GetMapping("/getcomputersbycomment/{comment}")
    public List<Computer> getComputersByComment(@PathVariable String comment){
        return computerService.getComputersByComment(comment);
    }

    @GetMapping("/getcomputersbyrate/{rate}")
    public List<Computer> getComputersByRate(@PathVariable int rate){
        return computerService.getComputersByRate(rate);
    }

    @GetMapping("/getcomputersbyadditionalfeature/{additionalfeature}")
    public List<Computer> getComputersByAdditionalFeature(@PathVariable String additionalfeature){
        return computerService.getComputersByAdditionalFeature(additionalfeature);
    }

    @GetMapping("/getcomputersbybrandandcomment/{name}/{comment}") //EDA
    public List<Computer> getComputersByBrandAndComment(@PathVariable String name, @PathVariable String comment){
        return computerService.getComputersByBrandAndComment(name,comment);
    }

    @GetMapping("/getcomputersbybrandandrate/{name}/{rate}") //EDA
    public List<Computer> getComputersByBrandAndRate(@PathVariable String name, @PathVariable int rate){
        return computerService.getComputersByBrandAndRate(name, rate);
    }

    @GetMapping("/getcomputersbyadditionalfeatureandcomment/{additionalfeature}/{comment}") //EDA
    public List<Computer> getComputersByAdditionalFeatureAndComment(@PathVariable String additionalfeature, @PathVariable String comment){
        return computerService.getComputersByAdditionalFeatureAndComment(additionalfeature, comment);
    }

    @GetMapping("/getcomputersbyadditionalfeatureandrate/{additionalfeature}/{rate}") //EDA
    public List<Computer> getComputersByAdditionalFeatureAndRate(@PathVariable String additionalfeature, @PathVariable int rate){
        return computerService.getComputersByAdditionalFeatureAndRate(additionalfeature, rate);
    }

    @GetMapping("/getcomputersbyadditionalfeatureandbrand/{additionalfeature}/{name}") //EDA
    public List<Computer> getComputersByAdditionalFeatureAndBrand(@PathVariable String additionalfeature, @PathVariable String name){
        return computerService.getComputersByAdditionalFeatureAndBrand(additionalfeature, name);
    }

    @GetMapping("/getcomputersbylabelandprice/{label}/{price}") //Muhammed
    public List<Computer> getPhonesByLabelAndPrice(@PathVariable String label, @PathVariable int price){
        return computerService.getComputersByLabelAndPrice(label, price);
    }
    @GetMapping("/getcomputersbylabelandscreensize/{label}/{screensize}") //Muhammed
    public List<Computer> getPhonesByLabelAndScreensize(@PathVariable String label, @PathVariable String screensize){
        return computerService.getComputersByLabelAndScreensize(label, screensize);
    }
    @GetMapping("/getcomputersbylabelandmodel/{label}/{model}") //Muhammed
    public List<Computer> getPhonesByLabelAndModel(@PathVariable String label, @PathVariable String model){
        return computerService.getComputersByLabelAndModel(label, model);
    }

    @GetMapping("/getcomputersbysearch")
    public List<Computer> getPhonesBySearch(@RequestParam(required = false) Integer product_id,
                                            @RequestParam(required = false) String model,
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
                if (currentComputer.getModel() != model) {
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
                if (currentComputer.getLabel() != label) {
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
                if (currentComputer.getScreenResolution() != screen_resolution) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (storage_capacity != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getStorageCapacity() != storage_capacity) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (memory != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getMemory() != memory) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (processor != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getProcessor() != processor) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (minprice != null && maxprice != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (maxprice < currentComputer.getPrice() && currentComputer.getPrice() < minprice) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (minscreensize != null && maxscreensize != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (maxscreensize < currentComputer.getScreensize() && currentComputer.getScreensize() < minscreensize) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (afs_name != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getAdditionalFeaturesList().get(i).getAfs_name() != afs_name) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (comment != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getCommentAndRatesList().get(i).getComment() != comment) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        if (rate != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getCommentAndRatesList().get(i).getRate() != rate) {
                    computerList.remove(i);
                    i--;
                }
            }
        }


        if (brand_name != null) {
            for (int i = 0; i < computerList.size(); i++) {
                Computer currentComputer = computerList.get(i);
                if (currentComputer.getBrandList().get(i).getBrand_name() != brand_name) {
                    computerList.remove(i);
                    i--;
                }
            }
        }

        return computerList;
    }

}
