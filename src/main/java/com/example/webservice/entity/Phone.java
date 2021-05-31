package com.example.webservice.entity;



import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Phone extends Product {
    private String internalMemory;
}
