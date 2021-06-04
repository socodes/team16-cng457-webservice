package com.example.webservice.repository;

import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query("SELECT p FROM Phone p")
    public List<Phone> getPhoneDetails();

    @Query("SELECT p FROM Phone p WHERE internalMemory LIKE %?1%")
    List<Phone> getPhonesByInternalMemory(String internalMemory);

    /*
    @Query("SELECT p FROM Phone p INNER JOIN Brand b ON p.product_id = b.brand_id WHERE b.brand_name LIKE %?1% AND p.product_id = ?2")
    public List<Phone> getPhonesFromBrandandID(String name,int id);

     */

    @Query("SELECT p FROM Phone p WHERE model LIKE %?1%")
    List<Phone> getPhonesByModel(String model);

    @Query("SELECT p FROM Phone p WHERE price LIKE %?1%")
    List<Phone> getPhonesByPrice(int price);

    @Query("SELECT p FROM Phone p WHERE label LIKE %?1%")
    List<Phone> getPhonesByLabel(String label);

    @Query("SELECT p FROM Phone p WHERE screensize LIKE %?1%")
    List<Phone> getPhonesByScreensize(String screensize);

    @Query("SELECT p FROM Phone p INNER JOIN Brand b ON p.product_id = b.brand_id WHERE b.brand_name LIKE %?1%")
    public List<Phone> getPhonesByBrand(String name);

    @Query("SELECT p FROM Phone p INNER JOIN CommentAndRate c ON p.product_id = c.comment_id WHERE c.comment LIKE %?1%")
    List<Phone> getPhonesByComment(String comment);

    @Query("SELECT p FROM Phone p INNER JOIN CommentAndRate c ON p.product_id = c.comment_id WHERE c.rate LIKE %?1%")
    List<Phone> getPhonesByRate(int rate);

    @Query("SELECT p FROM Phone p INNER JOIN AdditionalFeatures f ON p.product_id = f.afs_id WHERE f.afs_name LIKE %?1%")
    List<Phone> getPhonesByAdditionalFeature(String additionalfeature);

    @Query(value= "SELECT * FROM Brand\n" +
            "INNER JOIN Product ON Brand.brand_id = Product.product_id\n" +
            "INNER JOIN Phone ON Product.product_id = Phone.product_id\n" +
            "WHERE internal_memory BETWEEN ?1 AND ?2", nativeQuery = true)
    public List<Phone> getPhonesByInternalMemoryBetween(int minval, int maxval); //EDA

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN brand ON phone.product_id = brand.brand_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "WHERE brand.brand_name LIKE %?1% AND comment_and_rate.comment LIKE %?2%", nativeQuery = true)
    public List<Phone> getPhonesByBrandAndComment(String name, String comment); //EDA

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN brand ON phone.product_id = brand.brand_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "WHERE brand.brand_name LIKE %?1% AND comment_and_rate.rate LIKE %?2%", nativeQuery = true)
    public List<Phone> getPhonesByBrandAndRate(String name, int rate); //EDA

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON phone.product_id = additional_features.afs_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND comment_and_rate.comment LIKE %?2%", nativeQuery = true)
    public List<Phone> getPhonesByAdditionalFeatureAndComment(String additionalfeature, String comment); //EDA

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON phone.product_id = additional_features.afs_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND comment_and_rate.rate LIKE %?2%", nativeQuery = true)
    public List<Phone> getPhonesByAdditionalFeatureAndRate(String additionalfeature, int rate); //EDA

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON phone.product_id = additional_features.afs_id\n" +
            "INNER JOIN brand ON phone.product_id = brand.brand_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND brand.brand_name LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByAdditionalFeatureAndBrand(String additionalfeature, String name);  //EDA

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "WHERE product.price = ?2 AND product.label LIKE %?1%", nativeQuery = true)
    List<Phone> getPhonesByLabelAndPrice(String label, int price); //Muhammed

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "WHERE product.label = ?1 AND product.screensize LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByLabelAndScreensize(String label, String screensize);//Muhammed

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "WHERE product.label = ?1 AND product.model LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByLabelAndModel(String label, String model);//Muhammed

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "WHERE product.label = ?1 AND phone.internalmemory LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndLabel(String label, String internalmemory);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "WHERE product.screensize = ?1 AND phone.internalmemory LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndScreensize(String screensize, String internalmemory);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "WHERE product.model = ?1 AND phone.internalmemory LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndModel(String model, String internalmemory);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON phone.product_id = additional_features.afs_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND phone.internalMemory LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndAdditionalFeature(String additionalfeature, String internalmemory);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN brand ON phone.product_id = brand.brand_id\n" +
            "WHERE phone.internalMemory LIKE %?2% AND brand.brand_name LIKE %?1%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndName(String name, String internalmemory);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "WHERE phone.internalMemory LIKE %?2% AND comment_and_rate.rate LIKE %?1%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndRate(String rate, String internalmemory);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "WHERE phone.internalMemory LIKE %?2% AND comment_and_rate.comment LIKE %?1%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndComment(String comment, String internalmemory);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN additional_features ON phone.product_id = additional_features.afs_id\n" +
            "WHERE additional_features.afs_name LIKE %?1% AND product.model LIKE %?12", nativeQuery = true)
    List<Phone> getPhonesByAdditionalFeatureAndModel(String additionalfeature, String model);



/*
    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN brand ON phone.product_id = brand.brand_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "INNER JOIN additional_features ON phone.product_id = additional_features.afs_id\n" +
            "WHERE brand.brand_name LIKE %?1% AND comment_and_rate.comment LIKE %?2% AND additional_features.afs_name LIKE %?3%", nativeQuery = true)
    List<Phone> getPhonesByBrandAndCommentAndAdditionalFeature(String name, String comment, String additionalfeature);

    @Query(value= "SELECT * FROM phone\n" +
            "INNER JOIN product ON phone.product_id = product.product_id\n" +
            "INNER JOIN comment_and_rate ON phone.product_id = comment_and_rate.comment_id\n" +
            "WHERE phone.internal_memory LIKE %?1% AND comment_and_rate.comment LIKE %?2%", nativeQuery = true)
    List<Phone> getPhonesByInternalMemoryAndComment(String internalMemory, String comment); //EDA
 */
}
