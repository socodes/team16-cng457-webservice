/**
 * Importing required documents
 */
package com.example.webservice.controller;
import com.example.webservice.entity.AdditionalFeatures;
import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.service.AdditionalFeaturesService;
import com.example.webservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Controller method for phone
 */
@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    AdditionalFeaturesService additionalFeaturesService;


    /**
     *This query saves all attributes of the phone to database
     * @param p Phone object
     * @return the phone list to be saved to the service
     * @throws InterruptedException for interrupting potentially time-consuming threads
     */
    @PostMapping("/addphone")
    public Product savePhone(@RequestBody Phone p) throws InterruptedException {
        return phoneService.savePhone(p);
    }

    /**
     * This query gets all the attributes of the phones object by id from the database and saves as a list
     * @param id primary key of phone (generated automatically)
     * @return the phone list from service by id
     */
    @GetMapping("/getphone/{id}")
    public Product getPhone(@PathVariable int id) throws InterruptedException {
        return phoneService.getPhone(id);

    }

    /**
     * This query gets all the attributes of the phones object from the database and saves as a list
     * @return list of all attributes of the phone entity
     */
    @GetMapping("/getphonealldetails")
    public List<Phone> getPhoneDetails() {
        return   phoneService.getPhoneDetails();
    }

    /**
     * This query gets all the attributes of the phones object by internalMemory from the database and saves as a list
     * @param internalMemory an attribute in phone
     * @return the phones list from service by internalMemory
     */
    @GetMapping("/getphonesbyinternalmemory/{internalMemory}")
    public List<Phone> getPhonesByInternalMemory(@PathVariable String internalMemory) {
        return  phoneService.getPhonesByInternalMemory(internalMemory);

    }

    /**
     * This query gets all the attributes of the phones object by model from the database and saves as a list
     * @param model attribute of product
     * @return list of phones from database by their model given by the user
     */
    @GetMapping("/getphonesbymodel/{model}")
    public List<Phone> getPhonesByModel(@PathVariable String model) {
        return phoneService.getPhonesByModel(model);
    }

    /**
     * This query gets all the attributes of the phones object by price from the database and saves as a list
     * @param price attribute of product
     * @return list of phones from database by their price
     */
    @GetMapping("/getphonesbyprice/{price}")
    public List<Phone> getPhonesByPrice(@PathVariable int price) {

        return phoneService.getPhonesByPrice(price);

    }

    /**
     * This query gets all the attributes of the phones object by label from the database and saves as a list
     * @param label attribute of product
     * @return list of phones from database by their label
     */
    // Redundant, but keep it for GUI, it might be useful
    @GetMapping("/getphonesbylabel/{label}")
    public List<Phone> getPhonesByLabel(@PathVariable String label) {

       return phoneService.getPhonesByLabel(label);

    }

    /**
     * This query gets all the attributes of the phones object by screensize from the database and saves as a list
     * @param screensize attribute of product return list
     * @return list of phones from database by their screensize given by the user
     */
    @GetMapping("/getphonesbyscreensize/{screensize}")
    public List<Phone> getPhonesByScreensize(@PathVariable int screensize) {
        return phoneService.getPhonesByScreensize(screensize);

    }

    /**
     * This query gets all the attributes of the phones object by brandname from the database and saves as a list
     * @param  name attribute of brand return list of phones
     * @return list of phones from database by their brand_name
     */
    @GetMapping("/getphonesbybrand/{name}")
    public List<Phone> getPhonesFromBrand(@PathVariable String name) {
        return phoneService.getPhonesByBrand(name);

    }

    /**
     * This query gets all the attributes of the phones object from by comment the database and saves as a list
     * @param comment attribute of "comment and rate"
     * @return list of phones from database by their comment
     */
    @GetMapping("/getphonesbycomment/{comment}")
    public List<Phone> getPhonesByComment(@PathVariable String comment) {
        return phoneService.getPhonesByComment(comment);

    }

    /**
     * This query gets all the attributes of the phones object by rate from the database and saves as a list
     * @param rate attribute of "comment and rate"
     * @return list of phones from database by their rate given by the user
     */
    @GetMapping("/getphonesbyrate/{rate}")
    public List<Phone> getPhonesByRate(@PathVariable int rate) {

        return phoneService.getPhonesByRate(rate);

    }

    /**
     * This query gets all the attributes of the phones object by additional features from the database and saves as a list
     * @param additionalfeature attribute of "additional features"
     * @return list of phones from database by their additional feature
     */
    @GetMapping("/getphonesbyadditionalfeature/{additionalfeature}")
    public List<Phone> getPhonesByAdditionalFeature(@PathVariable String additionalfeature) {
        return phoneService.getPhonesByAdditionalFeature(additionalfeature);

    }

    /**
     * This query makes a connection between additional features and product which returns to a new table called product_has_afs
     * @param phoneID attribute of phone id return list of phones
     * @param afId attribute of additional feature id return list of additional features
     * @return phone object to be updated where the link between afs is saved in the table product_has_afs
     */
    @GetMapping("/updatePhone/addAdditionalFeatures/{phoneID}/{afId}")
    public Phone updatePhone(@PathVariable int phoneID, @PathVariable int afId) throws InterruptedException {

        Phone tempPhone = phoneService.getPhone(phoneID);
        AdditionalFeatures additionalFeatures = additionalFeaturesService.getAdditionalFeatures(afId);
        tempPhone.getAdditionalFeaturesList().add(additionalFeatures);
        return phoneService.savePhone(tempPhone);

    }

    /**
     * This query is just used from desktopApp. User uses the desktopApp to input a label and this label is saved to database
     * @param phoneID attribute of phone
     * @param label attribute of product
     * @return phone object which will be updated by the label attribute
     */
    @GetMapping("/updatePhone/label/{phoneID}/{label}")
    public Phone updatePhoneLabel(@PathVariable int phoneID, @PathVariable String label) throws InterruptedException {

        Phone tempPhone = phoneService.getPhone(phoneID);
        tempPhone.setLabel(label);
        return phoneService.savePhone(tempPhone);

    }

    /**
     * This query searches through all phone objects by given parameters.
     * The user can select more than one parameter to do the search operation.
     * @param product_id attribute of the product
     * @param model attribute of the product
     * @param model1 attribute of the product (if 2 models are given)
     * @param model2 attribute of the product (if 2 models are given)
     * @param price attribute of the product
     * @param label attribute of the product
     * @param screensize attribute of the product
     * @param internalMemory attribute of the product
     * @param internalMemory1 attribute of the product
     * @param internalMemory2 attribute of the product
     * @param minprice attribute of the product (range of price, min value)
     * @param maxprice attribute of the product (range of price, max value)
     * @param minscreensize attribute of the product (range of screensize, min value)
     * @param maxscreensize attribute of the product (range of screensize, max value)
     * @param afs_name attribute of the product
     * @param comment attribute of the product
     * @param rate attribute of the product
     * @param brand_name attribute of the product
     * @return list of phones that match the search criteria
     */
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

        return phoneList;
    }

}
