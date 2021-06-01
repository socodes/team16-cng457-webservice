package com.example.webservice.repository;

import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {



    @Query("SELECT p FROM Phone p")
    public List<Phone> getPhoneDetails();



    @Query("SELECT p FROM Product p,Brand b WHERE b.brand_id = p.brandid AND b.brand_id=2")
    public List<Phone> findByBrandName(int id); //not work for find bran
    /*
    @Query("SELECT p FROM Phone p WHERE p.brandList.brand_name LIKE %?1%")
    public List<Phone> getPhonesFromBrand(String name);
*/


}
