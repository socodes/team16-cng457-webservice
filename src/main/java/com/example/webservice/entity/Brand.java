package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brand_id;
    private String brand_name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> productList; //1 to Many relation

}
