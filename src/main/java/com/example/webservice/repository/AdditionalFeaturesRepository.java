package com.example.webservice.repository;

import com.example.webservice.entity.AdditionalFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdditionalFeaturesRepository extends JpaRepository<AdditionalFeatures, Integer> {
    @Query("SELECT f FROM AdditionalFeatures f")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails();

    @Query("SELECT f FROM AdditionalFeatures f WHERE afs_name LIKE %?1%") //select only touchscreen
    public List<AdditionalFeatures> getAdditionalFeaturesByName(String name);

}
