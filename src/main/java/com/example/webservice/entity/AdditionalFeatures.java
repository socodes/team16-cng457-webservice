package com.example.webservice.entity;

import lombok.*;

import javax.persistence.*;

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

}
