package com.example.webservice.controller;

import com.example.webservice.WebserviceApplication;
import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
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



    //Test all computers. Takes the all elements in db and checks the 2nd element, if its id is 5 or not.
    @Test
    void getComputerDetails() {

        assertEquals(
                this.restTemplate.getForObject("http://localhost:" + port + "/getcomputeralldetails", Computer[].class)[1].getProduct_id(),5);
    }

    //Test by id. Checks the 6th computer in db if its id is 6 or not.
    @Test
    void getComputer() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getcomputer/6",Computer.class).getProduct_id(),6);
    }
}