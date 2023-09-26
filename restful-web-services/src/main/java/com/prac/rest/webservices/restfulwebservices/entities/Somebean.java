package com.prac.rest.webservices.restfulwebservices.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties({"field1","field2"})
public class Somebean {
    private String field1;
//    @JsonIgnore
    private String field2;
    private String field3;
}
