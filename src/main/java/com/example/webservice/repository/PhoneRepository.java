package com.example.webservice.repository;

import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query("SELECT p FROM Phone p")
    public List<Phone> getPhoneDetails();

    @Query("SELECT p FROM Phone p INNER JOIN Brand b ON p.product_id = b.brand_id WHERE b.brand_name LIKE %?1%")
    public List<Phone> getPhonesFromBrand(String name);

    @Query("SELECT p FROM Phone p WHERE internalmemory LIKE %?1%")
    List<Phone> getPhonesByInternalMemory(String internalMemory);

    @Query("SELECT p FROM Phone p INNER JOIN Brand b ON p.product_id = b.brand_id WHERE b.brand_name LIKE %?1% AND p.product_id = ?2")
    public List<Phone> getPhonesFromBrandandID(String name,int id);


}
