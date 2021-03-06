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
    protected int product_id;
    protected String model;
    protected int price;
    protected String label;
    protected int screensize;

    public int getProduct_id(){
        return product_id;
    }

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // owned
    private List<CommentAndRate> commentAndRatesList;

    @ManyToMany() // owning
    @JoinTable(name = "product_has_afs", joinColumns = @JoinColumn(name = "afs_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<AdditionalFeatures> additionalFeaturesList;

    @OneToMany(mappedBy = "brand_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Brand> brandList;

}
