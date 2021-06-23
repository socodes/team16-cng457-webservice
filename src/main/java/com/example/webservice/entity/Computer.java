package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Computer extends Product{
    private String screenResolution;
    private String storageCapacity;
    private String memory;
    private String processor;
}
