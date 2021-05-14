package com.example.webservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    private String model;
    private int price;
    private String label;
    private String screensize;

    @ManyToOne
    private Brand brand; //1 to Many relation

    @OneToMany(mappedBy = "commentandrate", cascade = CascadeType.ALL)
    private List<CommentAndRate> commentAndRateList; //1 to Many relation


}
