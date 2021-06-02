package com.example.webservice.repository;

import com.example.webservice.entity.CommentAndRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentAndRateRepository extends JpaRepository<CommentAndRate, Integer> {
    @Query("SELECT c FROM CommentAndRate c")
    public List<CommentAndRate> getCommentAndRateDetails();

    @Query("SELECT c FROM CommentAndRate c WHERE rate LIKE %?1%")
    public List<CommentAndRate> getCommentAndRateByRate(int rate);

    @Query("SELECT c FROM CommentAndRate c WHERE comment LIKE %?1%")
    public List<CommentAndRate> getCommentAndRateByComment(String comment);



}
