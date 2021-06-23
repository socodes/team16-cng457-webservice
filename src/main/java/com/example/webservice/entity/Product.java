package com.example.webservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "product_id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String model;
    private int price;
    private String label;
    private int screensize;

    /**
     * One to many relation of product coments and rates
     */
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // owned
    private List<CommentAndRate> commentAndRatesList;

    /**
     * Many to many relation of products additional features
     * product_has_afs table was created with @JoinTable
     * for creating this table afs_id from additional features (primary key) and,
     * product_id from product (primary key) was used
     */
    @ManyToMany() // owning
    @JoinTable(name = "product_has_afs", joinColumns = @JoinColumn(name = "afs_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<AdditionalFeatures> additionalFeaturesList;

    /**
     * One to many relation of products brand
     */
    @OneToMany(mappedBy = "brand_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Brand> brandList;

}
