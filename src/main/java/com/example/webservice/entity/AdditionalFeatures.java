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
    @Column(name = "afs_facerecognition")
    private boolean faceRecognition;

    @Column(name = "afs_alldaybatterylife")
    private boolean allDayBatteryLife;

    @Column(name = "afs_extralongbatterylife")
    private boolean extraLongBatteryLife;

    @Column(name = "afs_touchscreen")
    private boolean touchscreen;

    @Column(name = "afs_fingerprintreader")
    private boolean fingerprintReader;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "afs_id")
    private AdditionalFeatures af_id;

    @ManyToMany(mappedBy = "additionalFeaturesList") // owned
    private List<Product> productList;


}
