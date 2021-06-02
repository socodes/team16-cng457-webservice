package com.example.webservice.repository;

import com.example.webservice.entity.Brand;
import com.example.webservice.entity.CommentAndRate;
import com.example.webservice.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentAndRateRepository extends JpaRepository<CommentAndRate, Integer> {
    @Query("SELECT c FROM CommentAndRate c")
    public List<CommentAndRate> getCommentAndRateDetails();

    @Query("SELECT c FROM CommentAndRate c WHERE rate LIKE '%1%' ")
    public List<CommentAndRate> getCommentAndRate1();

    @Query("SELECT c FROM CommentAndRate c WHERE rate LIKE '%2%' ")
    public List<CommentAndRate> getCommentAndRate2();

    @Query("SELECT c FROM CommentAndRate c WHERE rate LIKE '%3%' ")
    public List<CommentAndRate> getCommentAndRate3();

    @Query("SELECT c FROM CommentAndRate c WHERE rate LIKE '%4%' ")
    public List<CommentAndRate> getCommentAndRate4();

    @Query("SELECT c FROM CommentAndRate c WHERE rate LIKE '%5%' ")
    public List<CommentAndRate> getCommentAndRate5();
}
