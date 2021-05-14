package com.example.webservice.entity;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "computer")
public class Computer extends Product{

    private String ScreenResolution;
    private String StorageCapacity;
    private String Memory;
    private String Processor;
}
