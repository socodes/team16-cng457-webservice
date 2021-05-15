package com.example.webservice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commentandrate")
public class CommentAndRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "carid")
    private int comment_id;

    @Column(name = "carrate")
    private int rate;

    @Column(name = "carcomment")
    private String comment;

    @ManyToOne // owning
    private Product product;

}
