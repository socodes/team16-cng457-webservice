package com.example.webservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String model;
    private int price;
    private String label;
    private String screensize;

    @OneToMany(mappedBy = "comment_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // owned
    private List<CommentAndRate> commentAndRatesList;

    @ManyToMany() // owning
    @JoinTable(name = "product_has_afs", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "productList"))
    private List<AdditionalFeatures> additionalFeaturesList;

    @ManyToOne // owning
    private Brand brandList;
    /*
    @ManyToMany //owning
    @JoinTable(name = , joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "productList"))
    private List<Brand> brandList;
    */



}
