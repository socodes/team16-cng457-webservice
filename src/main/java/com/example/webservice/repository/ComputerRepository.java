package com.example.webservice.repository;

import com.example.webservice.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    @Query("SELECT c FROM Computer c")
    public List<Computer> getComputerDetails();

    @Query("SELECT c FROM Computer c INNER JOIN Brand b ON c.product_id = b.brand_id WHERE b.brand_name LIKE %?1%")
    public List<Computer> getComputerFromBrand(String name);

    @Query("SELECT c FROM Computer c WHERE screenresolution LIKE %?1%")
    public List<Computer> getComputersByScreenResolution(String screenresolution);

    @Query("SELECT c FROM Computer c INNER JOIN Brand b ON c.product_id = b.brand_id WHERE b.brand_name LIKE %?1% AND c.product_id = ?2")
    public List<Computer> getComputersFromBrandandID(String name,int id);

    @Query("SELECT c FROM Computer c WHERE storagecapacity LIKE %?1%")
    public List<Computer> getComputersByStorageCapacity(String storagecapacity);


    @Query("SELECT c FROM Computer c WHERE memory LIKE %?1%")
    public List<Computer> getComputersByMemory(String memory);

    @Query("SELECT c FROM Computer c WHERE processor LIKE %?1%")
    List<Computer> getComputersByProcessor(String processor);
}
