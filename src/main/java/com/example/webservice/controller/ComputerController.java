/**
 * Importing required documents
 */
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

/**
 * Controller method for computer
 */
@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;
    @Autowired
    AdditionalFeaturesService additionalFeaturesService;

    Lock lock = new ReentrantLock();

    /**
     * This query saves all attributes of the computer to database
     * @param c Computer object
     * @return computer object to be saved to the service
     * @throws InterruptedException for interrupting potentially time-consuming threads
     */
    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c) throws InterruptedException {
        lock.lock();
        //Thread.sleep(10000); //For testing lock, you can add this line.
        Computer cm =  computerService.saveComputer(c);
        lock.unlock();
        return cm;
    }

    /**
     * This query gets all the attributes of the computers object from the database and saves as a list
     * @return the list of all attributes of the computer entity which are computer id, screenResolution, storageCapacity, memory, processor
     */
    @GetMapping("/getcomputeralldetails")
    public List<Computer> getComputerDetails(){
        lock.lock();
        List<Computer> list =  computerService.getComputerDetails();
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by id from the database and saves as a list
     * @param id primary key of computer (generated automatically)
     * @return the computer list from service by id
     */
    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable int id){
        lock.lock();
        Computer list = computerService.getComputer(id);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by screen resolution from the database and saves as a list
     * @param screenResolution an attribute in computer
     * @return the computer list from service by screenResolution
     */
    @GetMapping("/getcomputersbyscreenresolution/{screenResolution}")
    public List<Computer> getComputerByScreenResolution(@PathVariable String screenResolution){
        lock.lock();
        List<Computer> list = computerService.getComputerByScreenResolution(screenResolution);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by storage capacity from the database and saves as a list
     * @param storageCapacity an attribute in computer
     * @return the computer list from service by storageCapacity
     */
    @GetMapping("/getcomputersbystoragecapacity/{storageCapacity}")
    public List<Computer> getComputerByStorageCapacity(@PathVariable String storageCapacity){
        lock.lock();
        List<Computer> list = computerService.getComputerByStorageCapacity(storageCapacity);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by memory from the database and saves as a list
     * @param memory an attribute in computer
     * @return the computer list from service by memory
     */
    @GetMapping("/getcomputersbymemory/{memory}")
    public List<Computer> getComputerByMemory(@PathVariable String memory){
        lock.lock();
        List<Computer> list = computerService.getComputerByMemory(memory);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by processor from the database and saves as a list
     * @param processor an attribute in computer
     * @return the computer list from service by processor
     */
    @GetMapping("/getcomputersbyprocessor/{processor}")
    public List<Computer> getComputerByProcessor(@PathVariable String processor){
        lock.lock();
        List<Computer> list = computerService.getComputerByProcessor(processor);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by model from the database and saves as a list
     * @param model attribute of product return list of computers that match the model parameter
     * @return list of the computers from database by their model given by the user
     */
    @GetMapping("/getcomputersbymodel/{model}")
    public List<Computer> getComputerByModel(@PathVariable String model){
        lock.lock();
        List<Computer> list = computerService.getComputerByModel(model);
        lock.unlock();
        return  list;
    }

    /**
     * This query gets all the attributes of the computers object by price from the database and saves as a list
     * @param price attribute of product return list of computers that match the price parameter
     * @return list of computers from database by their price given by the user
     */
    @GetMapping("/getcomputersbyprice/{price}")
    public List<Computer> getComputerByPrice(@PathVariable int price){
        lock.lock();
        List<Computer> list = computerService.getComputerByPrice(price);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by label from the database and saves as a list
     * @param label attribute of product return list of computers that match the label parameter
     * @return list of computers from database by their label given by the user
     */
    // Redundant, but keep it for GUI, it might be useful
    @GetMapping("/getcomputersbylabel/{label}")
    public List<Computer> getComputerByLabel(@PathVariable String label){
        lock.lock();
        List<Computer> list = computerService.getComputerByLabel(label);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by screensize from the database and saves as a list
     * @param screensize attribute of product return list of computers that match the screensize parameter
     * @return list of computers from database by their screensize given by the user
     */
    @GetMapping("/getcomputersbyscreensize/{screensize}")
    public List<Computer> getComputerByScreensize(@PathVariable int screensize){
        lock.lock();
        List<Computer> list = computerService.getComputerByScreensize(screensize);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by brandname from the database and saves as a list
     * @param brand_name attribute of brand return list of computers that match the brand_name parameter
     * @return lsit of computers from database by their brand_name given by the user
     */
    @GetMapping("/getcomputersbybrand/{brand_name}")
    public List<Computer> getComputersByBrand(@PathVariable String brand_name){
        lock.lock();
        List<Computer> list = computerService.getComputersByBrand(brand_name);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object from by comment the database and saves as a list
     * @param comment attribute of comment and rate return list of computers that match the comment parameter
     * @return list of computers from database by their comment given by the user
     */
    @GetMapping("/getcomputersbycomment/{comment}")
    public List<Computer> getComputersByComment(@PathVariable String comment){
        lock.lock();
        List<Computer> list = computerService.getComputersByComment(comment);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by rate from the database and saves as a list
     * @param rate attribute of comment and rate return list of computers that match the rate parameter
     * @return list of computers from database by their rate given by the user
     */
    @GetMapping("/getcomputersbyrate/{rate}")
    public List<Computer> getComputersByRate(@PathVariable int rate){
        lock.lock();
        List<Computer> list = computerService.getComputersByRate(rate);
        lock.unlock();
        return list;
    }

    /**
     * This query gets all the attributes of the computers object by additional feature from the database and saves as a list
     * @param additionalfeature attribute of additional feature return list of computers that match the additional feature parameter
     * @return list of computers from database by their additional feature given by the user
     */
    @GetMapping("/getcomputersbyadditionalfeature/{additionalfeature}")
    public List<Computer> getComputersByAdditionalFeature(@PathVariable String additionalfeature){
        lock.lock();
        List<Computer> list = computerService.getComputersByAdditionalFeature(additionalfeature);
        lock.unlock();
        return list;
    }

    /**
     * This query makes a connection between additional features and product which returns to a new table called product_has_afs
     * @param computerID attribute of computer id return list of computers
     * @param afId attribute of additional feature id return list of additional features
     * @return computer object to be updated where the link between afs is saved in the table product_has_afs
     */
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

    /**
     * This query is just used from desktopApp. User uses the desktopApp to input a label and this label is saved to database
     * @param computerID attribute of computer
     * @param label attribute of product
     * @return computer object which will be updated by the label attribute
     */
    @GetMapping("/updateComputer/label/{computerID}/{label}")
    public Computer updateComputerLabel(@PathVariable int computerID, @PathVariable String label){
        lock.lock();
        Computer tempComputer = computerService.getComputer(computerID);
        tempComputer.setLabel(label);
        Computer cm =  computerService.saveComputer(tempComputer);
        lock.unlock();
        return cm;
    }

    /**
     * This query searches through all computer objects by given parameters.
     * The user can select more than one parameter to do the search operation.
     * @param product_id attribute of the product
     * @param model attribute of the product
     * @param model1 attribute of the product (if 2 models are given)
     * @param model2 attribute of the product (if 2 models are given)
     * @param price attribute of the product
     * @param label attribute of the product
     * @param screensize attribute of the product
     * @param screen_resolution attribute of the product
     * @param storage_capacity attribute of the product
     * @param memory attribute of the product
     * @param processor attribute of the product
     * @param minprice attribute of the product (range of price, min value)
     * @param maxprice attribute of the product (range of price, max value)
     * @param minscreensize attribute of the product (range of screensize, min value)
     * @param maxscreensize attribute of the product (range of screensize, max value)
     * @param afs_name attribute of the product
     * @param comment attribute of the product
     * @param rate attribute of the product
     * @param brand_name attribute of the product
     * @return list of computers that match the search criteria
     */
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
