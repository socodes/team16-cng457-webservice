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
    @Column(name = "bid")
    private int brand_id;

    @Column(name = "bname")
    private String brand_name;

    @ManyToMany(mappedBy = "brandList") // owned
    private List<Product> productList;

}
