package com.prac.rest.webservices.restfulwebservices.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
