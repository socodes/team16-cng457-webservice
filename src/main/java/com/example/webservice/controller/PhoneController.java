package com.example.webservice.controller;

import com.example.webservice.entity.AdditionalFeatures;
import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.service.AdditionalFeaturesService;
import com.example.webservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    AdditionalFeaturesService additionalFeaturesService;

    Lock lock = new ReentrantLock();

    @PostMapping("/addphone")
    public Product savePhone(@RequestBody Phone p) throws InterruptedException {
        lock.lock();
        //Thread.sleep(10000); //For testing, you can add this line
        Product pr = phoneService.savePhone(p);
        lock.unlock();
        return pr;
    }

    @GetMapping("/getphone/{id}")
    public Product getPhone(@PathVariable int id) {
        return phoneService.getPhone(id);
    }

    @GetMapping("/getphonealldetails")
    public List<Phone> getPhoneDetails() {
        lock.lock();
        List<Phone> list =  phoneService.getPhoneDetails();
        lock.unlock();
        return  list;
    }

    @GetMapping("/getphonesbyinternalmemory/{internalMemory}")
    public List<Phone> getPhonesByInternalMemory(@PathVariable String internalMemory) {
        lock.lock();
        List<Phone> list =  phoneService.getPhonesByInternalMemory(internalMemory);
        lock.unlock();
        return  list;
    }

    @GetMapping("/getphonesbymodel/{model}")
    public List<Phone> getPhonesByModel(@PathVariable String model) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByModel(model);
        lock.unlock();
        return list;
    }

    @GetMapping("/getphonesbyprice/{price}")
    public List<Phone> getPhonesByPrice(@PathVariable int price) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByPrice(price);
        lock.unlock();
        return list;
    }

    // Redundant, but keep it for GUI, it might be useful
    @GetMapping("/getphonesbylabel/{label}")
    public List<Phone> getPhonesByLabel(@PathVariable String label) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByLabel(label);
        lock.unlock();
        return list;
    }

    @GetMapping("/getphonesbyscreensize/{screensize}")
    public List<Phone> getPhonesByScreensize(@PathVariable int screensize) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByScreensize(screensize);
        lock.unlock();
        return list;
    }

    @GetMapping("/getphonesbybrand/{name}")
    public List<Phone> getPhonesFromBrand(@PathVariable String name) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByBrand(name);
        lock.unlock();
        return list;
    }

    @GetMapping("/getphonesbycomment/{comment}")
    public List<Phone> getPhonesByComment(@PathVariable String comment) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByComment(comment);
        lock.unlock();
        return list;
    }

    @GetMapping("/getphonesbyrate/{rate}")
    public List<Phone> getPhonesByRate(@PathVariable int rate) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByRate(rate);
        lock.unlock();
        return list;

    }

    @GetMapping("/getphonesbyadditionalfeature/{additionalfeature}")
    public List<Phone> getPhonesByAdditionalFeature(@PathVariable String additionalfeature) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByAdditionalFeature(additionalfeature);
        lock.unlock();
        return list;
    }

    @GetMapping("/updatePhone/addAdditionalFeatures/{phoneID}/{afId}")
    public Phone updatePhone(@PathVariable int phoneID, @PathVariable int afId){
        lock.lock();
        Phone tempPhone = phoneService.getPhone(phoneID);
        AdditionalFeatures additionalFeatures = additionalFeaturesService.getAdditionalFeatures(afId);
        tempPhone.getAdditionalFeaturesList().add(additionalFeatures);
        Phone pr= phoneService.savePhone(tempPhone);
        lock.unlock();
        return pr;
    }

    @GetMapping("/updatePhone/label/{phoneID}/{label}")
    public Phone updatePhoneLabel(@PathVariable int phoneID, @PathVariable String label){
        lock.lock();
        Phone tempPhone = phoneService.getPhone(phoneID);
        tempPhone.setLabel(label);
        Phone ph = phoneService.savePhone(tempPhone);
        lock.unlock();
        return ph;
    }

    @GetMapping("/getphonesbysearch")
    public List<Phone> getPhonesBySearch(@RequestParam(required = false) Integer product_id,
                                  @RequestParam(required = false) String model,
                                  @RequestParam(required = false) String model1,
                                  @RequestParam(required = false) String model2,
                                  @RequestParam(required = false) Integer price,
                                  @RequestParam(required = false) String label,
                                  @RequestParam(required = false) Integer screensize,
                                  @RequestParam(required = false) String internalMemory,
                                  @RequestParam(required = false) String internalMemory1,
                                  @RequestParam(required = false) String internalMemory2,
                                  @RequestParam(required = false) Integer minprice,
                                  @RequestParam(required = false) Integer maxprice,
                                  @RequestParam(required = false) Integer minscreensize,
                                  @RequestParam(required = false) Integer maxscreensize,
                                  @RequestParam(required = false) String afs_name,
                                  @RequestParam(required = false) String comment,
                                  @RequestParam(required = false) Integer rate,
                                  @RequestParam(required = false) String brand_name) {
        lock.lock();
        List<Phone> phoneList = phoneService.getPhoneDetails();

        if (product_id != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getProduct_id() != product_id) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (internalMemory != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (!currentPhone.getInternalMemory().contains(internalMemory)) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (price != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getPrice() != price) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }


        if (minprice != null && maxprice != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if ((maxprice < currentPhone.getPrice()) || (currentPhone.getPrice() < minprice)) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (screensize != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getScreensize() != screensize) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (minscreensize != null && maxscreensize != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if ((maxscreensize < currentPhone.getScreensize()) || (currentPhone.getScreensize() < minscreensize)) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (model != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (!currentPhone.getModel().equals(model)) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (label != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (!currentPhone.getLabel().contains(label)) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (afs_name != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                for(int j = 0; j < currentPhone.getAdditionalFeaturesList().size(); j++){
                    if(!currentPhone.getAdditionalFeaturesList().get(j).getAfs_name().contains(afs_name)){
                        currentPhone.getAdditionalFeaturesList().remove(j);
                        j--;
                    }
                }
                if (currentPhone.getAdditionalFeaturesList().size() == 0) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (comment != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                for(int j = 0; j < currentPhone.getCommentAndRatesList().size(); j++){
                    if(!currentPhone.getCommentAndRatesList().get(j).getComment().contains(comment)){
                        currentPhone.getCommentAndRatesList().remove(j);
                        j--;
                    }
                }
                if (currentPhone.getCommentAndRatesList().size() == 0) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (rate != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                for(int j = 0; j < currentPhone.getCommentAndRatesList().size(); j++){
                    if (currentPhone.getCommentAndRatesList().get(j).getRate() != rate) {
                        currentPhone.getCommentAndRatesList().remove(j);
                        j--;
                    }
                }
                if(currentPhone.getCommentAndRatesList().size() == 0){
                    phoneList.remove(i);
                    i--;
                }
            }
        }


        if (brand_name != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                for(int j = 0; j < currentPhone.getBrandList().size(); j++){
                    if(!currentPhone.getBrandList().get(j).getBrand_name().equals(brand_name)){
                        currentPhone.getBrandList().remove(j);
                        j--;
                    }
                }
                if (currentPhone.getBrandList().size() == 0) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }
        lock.unlock();
        return phoneList;
    }

}
