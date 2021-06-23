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

    /**
     * This query saves all attributes of the comment and rate to database
     * @param c name of the entity (comment and rate)
     * @return save the comment and rate list to service
     */
    @PostMapping("/addcommentandrate")
    public CommentAndRate saveCommentAndRate(@RequestBody CommentAndRate c){
        return CommentAndRateService.saveCommentAndRate(c);
    }

    /**
     * This query gets all the attributes of the comment and rate object by id from the database and saves as a list
     * @param id primary key of brand (generated automatically)
     * @return get the comment and rate list from service by id
     */
    @GetMapping("/getcommentandrate/{id}")
    public CommentAndRate getCommentAndRate(@PathVariable int id){
        return CommentAndRateService.getCommentAndRate(id);
    }

    /**
     * This query gets all the attributes of the comment and rate object from the database and saves as a list
     * @return et all attributes of the comment and rate entity which are comment and rate id, comment and rate
     */
    @GetMapping("/getcommentandratealldetails")
    public List<CommentAndRate> getCommentAndRateDetails(){
        return CommentAndRateService.getCommentAndRateDetails();
    }

}
