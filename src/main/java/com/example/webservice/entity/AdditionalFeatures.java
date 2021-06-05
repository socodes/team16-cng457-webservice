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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "afs_id")
public class AdditionalFeatures {
    private String afs_name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int afs_id;

    @ManyToMany(mappedBy = "additionalFeaturesList", cascade = CascadeType.ALL) // owned
    private List<Product> productList;
}
