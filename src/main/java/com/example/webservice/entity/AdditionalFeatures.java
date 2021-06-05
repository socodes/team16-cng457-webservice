package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdditionalFeatures {
    private String afs_name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int afs_id;

    @ManyToMany(mappedBy = "additionalFeaturesList", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // owned
    private List<Product> productList;
}
