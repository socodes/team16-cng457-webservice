package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "af_id", referencedColumnName = "id")
    private AdditionalFeatures af_id;


}
