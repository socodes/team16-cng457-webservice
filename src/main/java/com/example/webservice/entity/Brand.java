package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brand_id;
    private String brand_name;
/*
    @ManyToMany(mappedBy = "brandList", cascade = CascadeType.ALL) // owned
    private List<Product> productList;
    */
    @OneToMany(mappedBy = "brandList", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // owned
    private List<Product> brandList;


}
