package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdditionalFeatures {
    private boolean faceRecognition;
    private boolean allDayBatteryLife;
    private boolean extraLongBatteryLife;
    private boolean touchscreen;
    private boolean fingerprintReader;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int afs_id;

    @ManyToMany(mappedBy = "additionalFeaturesList", cascade = CascadeType.ALL) // owned
    private List<Product> productList;
}
