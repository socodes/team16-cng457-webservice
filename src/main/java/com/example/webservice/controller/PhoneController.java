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
    public List<Phone> getPhonesByScreensize(@PathVariable int screensize) {
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
        int i = 0;
        if (product_id != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getProduct_id() != product_id) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (internalMemory != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getInternalMemory() != internalMemory) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if(internalMemory1 != null && internalMemory2 != null)
        {
            for(int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if(!currentPhone.getInternalMemory().equals(internalMemory1) && !currentPhone.getInternalMemory().equals(internalMemory2)) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (price != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getPrice() != price) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (minprice != null && maxprice != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (maxprice < currentPhone.getPrice() && currentPhone.getPrice() < minprice) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (screensize != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getScreensize() != screensize) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (minscreensize != null && maxscreensize != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (maxscreensize < currentPhone.getScreensize() && currentPhone.getScreensize() < minscreensize) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (model != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getModel() != model) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (model1 != null && model2 != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (!currentPhone.getModel().equals(model1) && !currentPhone.getModel().equals(model2)) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (label != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getLabel() != label) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }


        if (afs_name != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getAdditionalFeaturesList().get(i).getAfs_name() != afs_name) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (comment != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getCommentAndRatesList().get(i).getComment() != comment) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }

        if (rate != null) {
            for (i = 0; i < phoneList.size(); i++) {
                Phone currentPhone = phoneList.get(i);
                if (currentPhone.getCommentAndRatesList().get(i).getRate() != rate) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }


        if (brand_name != null) {
            for (i = 0; i < phoneList.size(); i++) {
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
