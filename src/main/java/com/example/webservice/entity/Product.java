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

    @OneToMany(mappedBy = "comment_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // owned
    private List<CommentAndRate> commentAndRatesList;

    @ManyToMany //owning
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private List<Brand> brandList;

    @ManyToMany // owning
    @JoinColumn(name = "afs_id", insertable = false, updatable = false)
    private List<AdditionalFeatures> additionalFeaturesList;


}
