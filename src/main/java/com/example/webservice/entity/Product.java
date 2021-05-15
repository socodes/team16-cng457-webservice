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
    @Column(name = "pmodel", nullable = false)
    private String model;

    @Column(name = "pprice")
    private int price;

    @Column(name = "plabel")
    private String label;

    @Column(name = "pscreensize")
    private String screensize;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL) // owned
    private List<CommentAndRate> commentAndRatesList;

    @ManyToMany(fetch = FetchType.EAGER) //owning
    @JoinTable(name = "ProductLines_has_b", joinColumns = @JoinColumn (name = "pmodel"), inverseJoinColumns = @JoinColumn (name = "bid"))
    private List<Brand> brandList;

    @ManyToMany(fetch = FetchType.EAGER) // owning
    @JoinTable(name = "ProductLines_has_af", joinColumns = @JoinColumn (name = "pmodel"), inverseJoinColumns = @JoinColumn (name = "afs_id"))
    private List<AdditionalFeatures> additionalFeaturesList;


}
