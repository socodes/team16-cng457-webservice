package com.example.webservice.repository;

import com.example.webservice.entity.AdditionalFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdditionalFeaturesRepository extends JpaRepository<AdditionalFeatures, Integer> {
    @Query("SELECT f FROM AdditionalFeatures f")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails();

    @Query("SELECT f FROM AdditionalFeatures f WHERE afs_name LIKE '%touchscreen%' ") //select only touchscreen
    public List<AdditionalFeatures> getAdditionalFeaturesTouchscreen();

    @Query("SELECT f FROM AdditionalFeatures f WHERE afs_name LIKE '%face recognition%' ") //select only face recognition
    public List<AdditionalFeatures> getAdditionalFeaturesFaceRecognition();

    @Query("SELECT f FROM AdditionalFeatures f WHERE afs_name LIKE '%fingerprint reader%' ") //select only fingerprint reader
    public List<AdditionalFeatures> getAdditionalFeaturesFingerprintReader();

    @Query("SELECT f FROM AdditionalFeatures f WHERE afs_name LIKE '%extralong battery life%' ") //select only extralong battery life
    public List<AdditionalFeatures> getAdditionalFeaturesExtraLongBatteryLife();

}
