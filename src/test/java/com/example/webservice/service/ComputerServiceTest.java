package com.example.webservice.service;

import com.example.webservice.entity.Computer;
import com.example.webservice.repository.ComputerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ComputerServiceTest {

    @InjectMocks
    ComputerService computerService;

    @Mock
    ComputerRepository computerRepository;

    @Test
    void getComputer() {
    }

    @Test
    void getComputerDetails() {
        Computer c1 = new Computer();
        Computer c2 = new Computer();

        List<Computer> computers = new ArrayList<>();

        computers.add(c1);
        computers.add(c2);

        when(computerRepository.findAll()).thenReturn(new ArrayList<>(computers));
        List<Computer> computerList = computerService.getComputerDetails();

        //Testing the list by its size
        Assertions.assertEquals(computers.size() +1 ,computerList.size()); // we add 1 more in real computer service method.

        //Test the first items in the lists, if they are equal or not.
        Assertions.assertEquals(computers.get(1),computerList.get(1));

    }
}