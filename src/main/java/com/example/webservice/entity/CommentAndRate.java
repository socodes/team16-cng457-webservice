package com.example.webservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "comment_id")
public class CommentAndRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_id;
    private int rate;
    private String comment;

    @ManyToOne // owning
    private Product product;

}
