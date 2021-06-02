package com.example.webservice.controller;


import com.example.webservice.entity.AdditionalFeatures;
import com.example.webservice.entity.CommentAndRate;
import com.example.webservice.service.CommentAndRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentAndRateController {
    @Autowired
    CommentAndRateService CommentAndRateService;

    @PostMapping("/addcommentandrate")
    public CommentAndRate saveCommentAndRate(@RequestBody CommentAndRate c){
        return CommentAndRateService.saveCommentAndRate(c);
    }

    @GetMapping("/getcommentandrate/{id}")
    public CommentAndRate getCommentAndRate(@PathVariable int id){
        return CommentAndRateService.getCommentAndRate(id);
    }

    @GetMapping("/getcommentandratealldetails")
    public List<CommentAndRate> getCommentAndRateDetails(){
        return CommentAndRateService.getCommentAndRateDetails();
    }

    @GetMapping("/getcommentandrate1")
    public List<CommentAndRate> getCommentAndRate1(){
        return CommentAndRateService.getCommentAndRate1();
    }

    @GetMapping("/getcommentandrate2")
    public List<CommentAndRate> getCommentAndRate2(){
        return CommentAndRateService.getCommentAndRate2();
    }

    @GetMapping("/getcommentandrate3")
    public List<CommentAndRate> getCommentAndRate3(){
        return CommentAndRateService.getCommentAndRate3();
    }

    @GetMapping("/getcommentandrate4")
    public List<CommentAndRate> getCommentAndRate4(){
        return CommentAndRateService.getCommentAndRate4();
    }

    @GetMapping("/getcommentandrate5")
    public List<CommentAndRate> getCommentAndRate5(){
        return CommentAndRateService.getCommentAndRate5();
    }
}
