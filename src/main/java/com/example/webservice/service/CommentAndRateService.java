package com.example.webservice.service;

import com.example.webservice.entity.CommentAndRate;
import com.example.webservice.repository.CommentAndRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentAndRateService {
    @Autowired
    CommentAndRateRepository CommentAndRateRepository;

    public CommentAndRate saveCommentAndRate (CommentAndRate c)
    {
        return CommentAndRateRepository.save(c);
    }

    public CommentAndRate getCommentAndRate(int id)
    {
        return CommentAndRateRepository.findById(id).orElse(null);
    }

    public List<CommentAndRate> getCommentAndRateDetails(){
        return CommentAndRateRepository.getCommentAndRateDetails();
    }

    public List<CommentAndRate> getCommentAndRate1(){
        return CommentAndRateRepository.getCommentAndRate1();
    }

    public List<CommentAndRate> getCommentAndRate2(){
        return CommentAndRateRepository.getCommentAndRate2();
    }

    public List<CommentAndRate> getCommentAndRate3(){
        return CommentAndRateRepository.getCommentAndRate3();
    }

    public List<CommentAndRate> getCommentAndRate4(){
        return CommentAndRateRepository.getCommentAndRate4();
    }
    public List<CommentAndRate> getCommentAndRate5(){
        return CommentAndRateRepository.getCommentAndRate5();
    }
}