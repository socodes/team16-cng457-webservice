package com.example.webservice.repository;

import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    @Query("SELECT * FROM Computer c")
    public List<Computer> getComputerDetails();

}
