package com.example.webservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "product")
public class Product {
    @Id
    private int model;

    private int price;
    private String label;
    private String screensize;

    @OneToMany(mappedBy = "comment_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // owned
    private List<CommentAndRate> commentAndRatesList;

    @ManyToMany //owning
    @JoinTable(name = "product_has_brand", joinColumns = @JoinColumn(name = "model"), inverseJoinColumns = @JoinColumn(name = "productList"))
    private List<Brand> brandList;

    @ManyToMany // owning
    @JoinColumn(name = "afs_id")
    private List<AdditionalFeatures> additionalFeaturesList;


}
