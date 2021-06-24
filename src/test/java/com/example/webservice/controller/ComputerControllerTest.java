package com.example.webservice.controller;

import com.example.webservice.WebserviceApplication;
import com.example.webservice.entity.Computer;
import com.example.webservice.service.ComputerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = WebserviceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComputerControllerTest {

    @InjectMocks
    ComputerController computerController;

    @Mock
    ComputerService computerService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;



    @Test
    void getComputerDetails() {

        Computer c1 = new Computer();
        Computer c2 = new Computer();

        List<Computer> computers = new ArrayList<>();

        computers.add(c1);
        computers.add(c2);

        when(computerService.getComputerDetails()).thenReturn(new ArrayList(computers));

        List<Computer> computerList = computerController.getComputerDetails();
        Assertions.assertEquals(computers.size(),computerList.size());
    }

    @Test
    void getComputer() {
    }
}