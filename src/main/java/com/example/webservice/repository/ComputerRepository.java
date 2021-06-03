package com.example.webservice.repository;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    @Query("SELECT c FROM Computer c")
    public List<Computer> getComputerDetails();

    @Query("SELECT c FROM Computer c WHERE screenresolution LIKE %?1%")
    public List<Computer> getComputersByScreenResolution(String screenresolution);

    @Query("SELECT c FROM Computer c WHERE storagecapacity LIKE %?1%")
    public List<Computer> getComputersByStorageCapacity(String storagecapacity);

    @Query("SELECT c FROM Computer c WHERE memory LIKE %?1%")
    public List<Computer> getComputersByMemory(String memory);

    @Query("SELECT c FROM Computer c WHERE processor LIKE %?1%")
    List<Computer> getComputersByProcessor(String processor);

    @Query("SELECT c FROM Computer c WHERE model LIKE %?1%")
    List<Computer> getComputerByModel(String model);

    @Query("SELECT c FROM Computer c WHERE price LIKE ?2")
    List<Computer> getComputerByPrice(int price);

    @Query("SELECT c FROM Computer c WHERE label LIKE %?1%")
    List<Computer> getComputerByLabel(String label);

    @Query("SELECT c FROM Computer c WHERE screensize LIKE %?1%")
    List<Computer> getComputerByScreensize(String screensize);

    @Query("SELECT c FROM Computer c INNER JOIN Brand b ON c.product_id = b.brand_id WHERE b.brand_name LIKE %?1%")
    List<Computer> getComputersByBrand(String name);

    @Query("SELECT c FROM Computer c INNER JOIN CommentAndRate cr ON c.product_id = cr.comment_id WHERE cr.comment LIKE %?1%")
    List<Computer> getComputersByComment(String comment);

    @Query("SELECT c FROM Computer c INNER JOIN CommentAndRate cr ON c.product_id = cr.comment_id WHERE cr.rate LIKE ?1")
    List<Computer> getComputersByRate(int rate);

    @Query("SELECT c FROM Computer c INNER JOIN AdditionalFeatures f ON c.product_id = f.afs_id WHERE f.afs_name LIKE %?1%")
    List<Computer> getComputersByAdditionalFeature(String additionalfeature);

    @Query(value= "SELECT * FROM computer\n" +
            "INNER JOIN product ON computer.product_id = product.product_id\n" +
            "INNER JOIN brand ON computer.product_id = brand.brand_id\n" +
            "INNER JOIN comment_and_rate ON computer.product_id = comment_and_rate.comment_id\n" +
            "WHERE brand.brand_name LIKE %?1% AND comment_and_rate.comment LIKE %?2%", nativeQuery = true)
    List<Computer> getComputersByBrandAndComment(String name, String comment); //EDA

    @Query(value= "SELECT * FROM computer\n" +
            "INNER JOIN product ON computer.product_id = product.product_id\n" +
            "INNER JOIN brand ON computer.product_id = brand.brand_id\n" +
            "INNER JOIN comment_and_rate ON computer.product_id = comment_and_rate.comment_id\n" +
            "WHERE brand.brand_name LIKE %?1% AND comment_and_rate.rate LIKE %?2%", nativeQuery = true)
    List<Computer> getComputersByBrandAndRate(String name, int rate); //EDA

    @Query(value= "SELECT * FROM computer\n" +
            "INNER JOIN product ON computer.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON computer.product_id = additional_features.afs_id\n" +
            "INNER JOIN comment_and_rate ON computer.product_id = comment_and_rate.comment_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND comment_and_rate.comment LIKE %?2%", nativeQuery = true)
    List<Computer> getComputersByAdditionalFeatureAndComment(String additionalfeature, String comment);

    @Query(value= "SELECT * FROM computer\n" +
            "INNER JOIN product ON computer.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON computer.product_id = additional_features.afs_id\n" +
            "INNER JOIN comment_and_rate ON computer.product_id = comment_and_rate.comment_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND comment_and_rate.rate LIKE %?2%", nativeQuery = true)
    List<Computer> getComputersByAdditionalFeatureAndRate(String additionalfeature, int rate);

    @Query(value= "SELECT * FROM computer\n" +
            "INNER JOIN product ON computer.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON computer.product_id = additional_features.afs_id\n" +
            "INNER JOIN brand ON computer.product_id = brand.brand_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND brand.brand_name LIKE %?2%", nativeQuery = true)
    List<Computer> getComputersByAdditionalFeatureAndBrand(String additionalfeature, String name);


    /*
    @Query("SELECT c FROM Computer c INNER JOIN Brand b ON c.product_id = b.brand_id WHERE b.brand_name LIKE %?1% AND c.product_id = ?2")
    public List<Computer> getComputersFromBrandAndID(String name, int id);

     */
}
