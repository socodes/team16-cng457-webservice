package com.example.webservice.controller;

import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @PostMapping("/addphone")
    public Product savePhone(@RequestBody Phone p) {
        return phoneService.savePhone(p);
    }

    @GetMapping("/getphone/{id}")
    public Product getPhone(@PathVariable int id) {
        return phoneService.getPhone(id);
    }

    @GetMapping("/getphonealldetails")
    public List<Phone> getPhoneDetails() {
        return phoneService.getPhoneDetails();
    }

    @GetMapping("/getphonesbyinternalmemory/{internalmemory}")
    public List<Phone> getPhonesByInternalMemory(@PathVariable String internalMemory) {
        return phoneService.getPhonesByInternalMemory(internalMemory);
    }

    /*
    @GetMapping("/getphonesbybrandandid/{name}/{id}")
    public List<Phone> getPhonesFromBrandandID(@PathVariable String name,@PathVariable int id){
        return phoneService.getPhonesFromBrandandID(name,id);
    } */

    @GetMapping("/getphonesbymodel/{model}")
    public List<Phone> getPhonesByModel(@PathVariable String model) {
        return phoneService.getPhonesByModel(model);
    }

    @GetMapping("/getphonesbyprice/{price}")
    public List<Phone> getPhonesByPrice(@PathVariable int price) {
        return phoneService.getPhonesByPrice(price);
    }

    @GetMapping("/getphonesbylabel/{label}")
    public List<Phone> getPhonesByLabel(@PathVariable String label) {
        return phoneService.getPhonesByLabel(label);
    }

    @GetMapping("/getphonesbyscreensize/{screensize}")
    public List<Phone> getPhonesByScreensize(@PathVariable String screensize) {
        return phoneService.getPhonesByScreensize(screensize);
    }

    @GetMapping("/getphonesbybrand/{name}")
    public List<Phone> getPhonesFromBrand(@PathVariable String name) {
        return phoneService.getPhonesByBrand(name);
    }

    @GetMapping("/getphonesbycomment/{comment}")
    public List<Phone> getPhonesByComment(@PathVariable String comment) {
        return phoneService.getPhonesByComment(comment);
    }

    @GetMapping("/getphonesbyrate/{rate}")
    public List<Phone> getPhonesByRate(@PathVariable int rate) {
        return phoneService.getPhonesByRate(rate);
    }

    @GetMapping("/getphonesbyadditionalfeature/{additionalfeature}")
    public List<Phone> getPhonesByAdditionalFeature(@PathVariable String additionalfeature) {
        return phoneService.getPhonesByAdditionalFeature(additionalfeature);
    }

    @GetMapping("/getphonesbyinternalmemorybetween/{minval}/{maxval}") //EDA
    public List<Phone> getPhonesByInternalMemoryBetween(@PathVariable int minval, @PathVariable int maxval) {
        return phoneService.getPhonesByInternalMemoryBetween(minval, maxval);
    }

    @GetMapping("/getphonesbybrandandcomment/{name}/{comment}") //EDA
    public List<Phone> getPhonesByBrandAndComment(@PathVariable String name, @PathVariable String comment) {
        return phoneService.getPhonesByBrandAndComment(name, comment);
    }

    @GetMapping("/getphonesbybrandandrate/{name}/{rate}") //EDA
    public List<Phone> getPhonesByBrandAndRate(@PathVariable String name, @PathVariable int rate) {
        return phoneService.getPhonesByBrandAndRate(name, rate);
    }

    @GetMapping("/getphonesbyadditionalfeatureandcomment/{additionalfeature}/{comment}") //EDA
    public List<Phone> getPhonesByAdditionalFeatureAndComment(@PathVariable String additionalfeature, @PathVariable String comment) {
        return phoneService.getPhonesByAdditionalFeatureAndComment(additionalfeature, comment);
    }

    @GetMapping("/getphonesbyadditionalfeatureandrate/{additionalfeature}/{rate}") //EDA
    public List<Phone> getPhonesByAdditionalFeatureAndRate(@PathVariable String additionalfeature, @PathVariable int rate) {
        return phoneService.getPhonesByAdditionalFeatureAndRate(additionalfeature, rate);
    }

    @GetMapping("/getphonesbyadditionalfeatureandbrand/{additionalfeature}/{name}") //EDA
    public List<Phone> getPhonesByAdditionalFeatureAndBrand(@PathVariable String additionalfeature, @PathVariable String name) {
        return phoneService.getPhonesByAdditionalFeatureAndBrand(additionalfeature, name);
    }

    @GetMapping("/getphonesbylabelandprice/{label}/{price}") //Muhammed
    public List<Phone> getPhonesByLabelAndPrice(@PathVariable String label, @PathVariable int price) {
        return phoneService.getPhonesByLabelAndPrice(label, price);
    }

    @GetMapping("/getphonesbylabelandscreensize/{label}/{screensize}") //Muhammed
    public List<Phone> getPhonesByLabelAndScreensize(@PathVariable String label, @PathVariable String screensize) {
        return phoneService.getPhonesByLabelAndScreensize(label, screensize);
    }

    @GetMapping("/getphonesbylabelandmodel/{label}/{model}") //Muhammed
    public List<Phone> getPhonesByLabelAndModel(@PathVariable String label, @PathVariable String model) {
        return phoneService.getPhonesByLabelAndModel(label, model);
    }

    @GetMapping("/getphonesbyinternalmemoryandlabel/{label}/{internalmemory}") //Muhammed
    public List<Phone> getPhonesByInternalMemoryAndLabel(@PathVariable String label, @PathVariable String internalmemory) {
        return phoneService.getPhonesByInternalMemoryAndLabel(label, internalmemory);
    }

    @GetMapping("/getphonesbyinternalmemoryandscreensize/{screensize}/{internalmemory}") //Muhammed
    public List<Phone> getPhonesByInternalMemoryAndScreensize(@PathVariable String screensize, @PathVariable String internalmemory) {
        return phoneService.getPhonesByInternalMemoryAndScreensize(screensize, internalmemory);
    }

    @GetMapping("/getphonesbyinternalmemoryandmodel/{model}/{internalmemory}") //Muhammed
    public List<Phone> getPhonesByInternalMemoryAndModel(@PathVariable String model, @PathVariable String internalmemory) {
        return phoneService.getPhonesByInternalMemoryAndModel(model, internalmemory);
    }

    @GetMapping("/getphonesbyinternalmemoryandadditionalfeature/{additionalfeature}/{internalmemory}") //Muhammed
    public List<Phone> getPhonesByInternalMemoryAndAdditionalFeature(@PathVariable String additionalfeature, @PathVariable String internalmemory) {
        return phoneService.getPhonesByInternalMemoryAndAdditionalFeature(additionalfeature, internalmemory);
    }

    @GetMapping("/getphonesbyinternalmemoryandname/{name}/{internalmemory}") //Muhammed
    public List<Phone> getPhonesByInternalMemoryAndName(@PathVariable String name, @PathVariable String internalmemory) {
        return phoneService.getPhonesByInternalMemoryAndName(name, internalmemory);
    }

    @GetMapping("/getphonesbyinternalmemoryandrate/{rate}/{internalmemory}") //Muhammed
    public List<Phone> getPhonesByInternalMemoryAndRate(@PathVariable String rate, @PathVariable String internalmemory) {
        return phoneService.getPhonesByInternalMemoryAndRate(rate, internalmemory);
    }

    @GetMapping("/getphonesbyinternalmemoryandcomment/{comment}/{internalmemory}") //Muhammed
    public List<Phone> getPhonesByInternalMemoryAndComment(@PathVariable String comment, @PathVariable String internalmemory) {
        return phoneService.getPhonesByInternalMemoryAndComment(comment, internalmemory);
    }

    @GetMapping("/getphonesbyadditionalfeatureandmodel/{additionalfeature}/{model}") //Muhammed
    public List<Phone> getPhonesByAdditionalFeatureAndModel(@PathVariable String additionalfeature, @PathVariable String model) {
        return phoneService.getPhonesByAdditionalFeatureAndModel(additionalfeature, model);
    }

    //internal memory
    //comment
    /*
    @GetMapping("/getphonesbybrandandcommentandrate/{name}/{comment}/{additionalfeature}") //EDA
    public List<Phone> getPhonesByBrandAndCommentAndAdditionalFeature(@PathVariable String name, @PathVariable String comment, @PathVariable String additionalfeature){
        return phoneService.getPhonesByBrandAndCommentAndAdditionalFeature(name,comment, additionalfeature);
    }
*/

    //atacan

    @GetMapping("/getphonesbysearch")
    public List<Phone> getPhonesBySearch(@RequestParam(required = false) Integer product_id,
                                  @RequestParam(required = false) String model,
                                  @RequestParam(required = false) Integer price,
                                  @RequestParam(required = false) String label,
                                  @RequestParam(required = false) Integer screensize,
                                  @RequestParam(required = false) String internalMemory,
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
                if (currentPhone.getInternalMemory() != internalMemory) {
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
                if (maxprice < currentPhone.getPrice() && currentPhone.getPrice() < minprice) {
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
                if (maxscreensize < currentPhone.getScreensize() && currentPhone.getScreensize() < minscreensize) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (model != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getModel() != model) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (label != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getLabel() != label) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }


        if (afs_name != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getAdditionalFeaturesList().get(i).getAfs_name() != afs_name) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (comment != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getCommentAndRatesList().get(i).getComment() != comment) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (rate != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getCommentAndRatesList().get(i).getRate() != rate) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }


        if (brand_name != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getBrandList().get(i).getBrand_name() != brand_name) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        return phoneList;
    }

}
