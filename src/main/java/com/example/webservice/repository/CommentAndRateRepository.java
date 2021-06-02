package com.example.webservice.repository;

import com.example.webservice.entity.CommentAndRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentAndRateRepository extends JpaRepository<CommentAndRate, Integer> {
    @Query("SELECT c FROM CommentAndRate c")
    public List<CommentAndRate> getCommentAndRateDetails();
}
