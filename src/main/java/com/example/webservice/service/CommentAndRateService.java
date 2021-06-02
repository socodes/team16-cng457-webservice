package com.example.webservice.service;

import com.example.webservice.entity.Brand;
import com.example.webservice.entity.CommentAndRate;
import com.example.webservice.repository.BrandRepository;
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
}
