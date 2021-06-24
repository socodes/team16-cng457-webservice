package com.example.webservice.service;


import com.example.webservice.entity.Computer;
import com.example.webservice.entity.Phone;
import com.example.webservice.repository.PhoneRepository;
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
class PhoneServiceTest {

    @InjectMocks
    PhoneService phoneService;

    @Mock
    PhoneRepository phoneRepository;

    @Test
    void getPhone() {
    }

    @Test
    void getPhoneDetails() {

        Phone p1 = new Phone();
        Phone p2 = new Phone();

        List<Phone> phones = new ArrayList<>();

        phones.add(p1);
        phones.add(p2);

        when(phoneRepository.findAll()).thenReturn(new ArrayList<>(phones));
        List<Phone> phoneList = phoneService.getPhoneDetails();

        //Testing the list by its size
        Assertions.assertEquals(phones.size() +1 ,phoneList.size()); // we add 1 more in real computer service method.

        //Test the first items in the lists, if they are equal or not.
        Assertions.assertEquals(phones.get(1),phoneList.get(1));
    }
}