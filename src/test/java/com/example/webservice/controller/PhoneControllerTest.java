package com.example.webservice.controller;

import com.example.webservice.WebserviceApplication;
import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import com.example.webservice.entity.Product;
import com.example.webservice.service.ComputerService;
import com.example.webservice.service.PhoneService;
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
class PhoneControllerTest {
    @InjectMocks
    PhoneController phoneController;

    @Mock
    PhoneService phoneService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void getPhoneId() {
           assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getphone/1",Phone.class).getProduct_id(),1);
    }

    @Test
    void getPhoneDetails() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getphonealldetails",Phone[].class)[1].getProduct_id(),2);
    }
}