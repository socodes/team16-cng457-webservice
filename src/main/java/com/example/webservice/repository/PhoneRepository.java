package com.example.webservice.repository;

import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
<<<<<<< Updated upstream
=======

    @Query("SELECT p FROM Phone p")
    public List<Phone> getPhoneDetails();

    List<Phone> findByBrandList(String brandList);



>>>>>>> Stashed changes
}
