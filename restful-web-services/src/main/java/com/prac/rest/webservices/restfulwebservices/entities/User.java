package com.prac.rest.webservices.restfulwebservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Details")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Size(min=2,message = "Name should have atleast 2 char ")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Birth Date should be in Past")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(int id,String name, LocalDate birthDate ){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
