package com.example.webservice.repository;

import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query("SELECT p FROM Phone p WHERE internalMemory LIKE %?1%")
    List<Phone> getPhonesByInternalMemory(String internalMemory);

    @Query("SELECT p FROM Phone p WHERE model LIKE %?1%")
    List<Phone> getPhonesByModel(String model);

    @Query("SELECT p FROM Phone p WHERE price LIKE ?1")
    List<Phone> getPhonesByPrice(int price);

    @Query("SELECT p FROM Phone p WHERE label LIKE %?1%")
    List<Phone> getPhonesByLabel(String label);

    @Query("SELECT p FROM Phone p WHERE screensize LIKE ?1")
    List<Phone> getPhonesByScreensize(int screensize);

    @Query("SELECT p FROM Phone p INNER JOIN Brand b ON p.product_id = b.brand_id WHERE b.brand_name LIKE %?1%")
    public List<Phone> getPhonesByBrand(String name);

    @Query("SELECT p FROM Phone p INNER JOIN CommentAndRate c ON p.product_id = c.comment_id WHERE c.comment LIKE %?1%")
    List<Phone> getPhonesByComment(String comment);

    @Query("SELECT p FROM Phone p INNER JOIN CommentAndRate c ON p.product_id = c.comment_id WHERE c.rate LIKE ?1")
    List<Phone> getPhonesByRate(int rate);

    @Query("SELECT p FROM Phone p INNER JOIN AdditionalFeatures f ON p.product_id = f.afs_id WHERE f.afs_name LIKE %?1%")
    List<Phone> getPhonesByAdditionalFeature(String additionalfeature);

}
