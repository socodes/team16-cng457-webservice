package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "afs")
public class AdditionalFeatures {
    private boolean faceRecognition;
    private boolean allDayBatteryLife;
    private boolean extraLongBatteryLife;
    private boolean touchscreen;
    private boolean fingerprintReader;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int afs_id;

    @ManyToMany(mappedBy = "additionalFeaturesList") // owned
    private List<Product> productList;
}
