package com.example.webservice.repository;

import com.example.webservice.entity.AdditionalFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdditionalFeaturesRepository extends JpaRepository<AdditionalFeatures, Integer> {

    /**
     *
     * @return a list of additional feature attributes
     */
    @Query("SELECT f FROM AdditionalFeatures f")
    public List<AdditionalFeatures> getAdditionalFeaturesDetails();

    /**
     *
     * @param name specific name of the attribute
     * @return a list of additional feature attributes by specific name
     */
    @Query("SELECT f FROM AdditionalFeatures f WHERE afs_name LIKE %?1%") //select only touchscreen
    public List<AdditionalFeatures> getAdditionalFeaturesByName(String name);

}
