package com.example.webservice.entity;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "computer")
public class Computer extends Product{
    @Column(name = "comp_screenresolution")
    private String ScreenResolution;

    @Column(name = "comp_storagecapacity")
    private String StorageCapacity;

    @Column(name = "comp_memory")
    private String Memory;

    @Column(name = "comp_processor")
    private String Processor;
}
