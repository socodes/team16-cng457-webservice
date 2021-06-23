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

    /**
     *This query saves all attributes of the phone to database
     * @param p name of the entity
     * @return save the phone list to service
     * @throws InterruptedException for interrupting potentially time-consuming threads
     */
    @PostMapping("/addphone")
    public Product savePhone(@RequestBody Phone p) throws InterruptedException {
        lock.lock();
        //Thread.sleep(10000); //For testing, you can add this line
        Product pr = phoneService.savePhone(p);
        lock.unlock();
        return pr;
    }

    /**
     * This query gets all the attributes of the phones object by id from the database and saves as a list
     * @param id primary key of phone (generated automatically)
     * @return get the phone list from service by id
     */
    @GetMapping("/getphone/{id}")
    public Product getPhone(@PathVariable int id) {
        return phoneService.getPhone(id);
    }

    /**
     * This query gets all the attributes of the phones object from the database and saves as a list
     * @return get all attributes of the phone entity which are phone id and internal memory
     */
    @GetMapping("/getphonealldetails")
    public List<Phone> getPhoneDetails() {
        lock.lock();
        List<Phone> list =  phoneService.getPhoneDetails();
        lock.unlock();
        return  list;
    }

    /**
     * This query gets all the attributes of the phones object by internalMemory from the database and saves as a list
     * @param internalMemory an attribute in phone
     * @return get the phones list from service by internalMemory
     */
    @GetMapping("/getphonesbyinternalmemory/{internalMemory}")
    public List<Phone> getPhonesByInternalMemory(@PathVariable String internalMemory) {
        lock.lock();
        List<Phone> list =  phoneService.getPhonesByInternalMemory(internalMemory);
        lock.unlock();
        return  list;
    }

    /**
     * This query gets all the attributes of the phones object by model from the database and saves as a list
     * @param model attribute of product return list of phones that match the model parameter
     * @return gets the phones from database by their model given by the user
     */
    @GetMapping("/getphonesbymodel/{model}")
    public List<Phone> getPhonesByModel(@PathVariable String model) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByModel(model);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the phones object by price from the database and saves as a list
     * @param price attribute of product return list of phones that match the price parameter
     * @return gets the phones from database by their price given by the user
     */
    @GetMapping("/getphonesbyprice/{price}")
    public List<Phone> getPhonesByPrice(@PathVariable int price) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByPrice(price);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the phones object by label from the database and saves as a list
     * @param label attribute of product return list of phones that match the label parameter
     * @return gets the phones from database by their label given by the user
     */
    // Redundant, but keep it for GUI, it might be useful
    @GetMapping("/getphonesbylabel/{label}")
    public List<Phone> getPhonesByLabel(@PathVariable String label) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByLabel(label);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the phones object by screensize from the database and saves as a list
     * @param screensize attribute of product return list of phones that match the screensize parameter
     * @return gets the phones from database by their screensize given by the user
     */
    @GetMapping("/getphonesbyscreensize/{screensize}")
    public List<Phone> getPhonesByScreensize(@PathVariable int screensize) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByScreensize(screensize);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the phones object by brandname from the database and saves as a list
     * @param  name attribute of brand return list of phones that match the brand_name parameter
     * @return gets the phones from database by their brand_name given by the user
     */
    @GetMapping("/getphonesbybrand/{name}")
    public List<Phone> getPhonesFromBrand(@PathVariable String name) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByBrand(name);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the phones object from by comment the database and saves as a list
     * @param comment attribute of comment and rate return list of phones that match the comment parameter
     * @return gets the phones from database by their comment given by the user
     */
    @GetMapping("/getphonesbycomment/{comment}")
    public List<Phone> getPhonesByComment(@PathVariable String comment) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByComment(comment);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the phones object by rate from the database and saves as a list
     * @param rate attribute of comment and rate return list of phones that match the rate parameter
     * @return gets the phones from database by their rate given by the user
     */
    @GetMapping("/getphonesbyrate/{rate}")
    public List<Phone> getPhonesByRate(@PathVariable int rate) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByRate(rate);
        lock.unlock();
        return list;

    }

    /**
     * This query gets all the attributes of the phones object by additional feature from the database and saves as a list
     * @param additionalfeature attribute of additional feature return list of phones that match the additional feature parameter
     * @return gets the phones from database by their additional feature given by the user
     */
    @GetMapping("/getphonesbyadditionalfeature/{additionalfeature}")
    public List<Phone> getPhonesByAdditionalFeature(@PathVariable String additionalfeature) {
        lock.lock();
        List<Phone> list = phoneService.getPhonesByAdditionalFeature(additionalfeature);
        lock.unlock();
        return list;
    }

    /**
     * This query makes a connection between additional features and product which returns to a new table called product_has_afs
     * @param phoneID attribute of phone id return list of phones
     * @param afId attribute of additional feature id return list of phones
     * @return to the table product_has_afs
     */
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
