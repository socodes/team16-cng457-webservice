package com.example.webservice.controller;


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

}
