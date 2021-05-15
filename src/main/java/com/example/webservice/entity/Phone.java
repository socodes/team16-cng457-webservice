package com.example.webservice.entity;



import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phone")
public class Phone extends Product {
    @Column(name = "phone_internalmemory")
    private String InternalMemory;
}
