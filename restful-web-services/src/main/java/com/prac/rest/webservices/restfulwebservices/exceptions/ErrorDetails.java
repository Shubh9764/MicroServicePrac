package com.prac.rest.webservices.restfulwebservices.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private LocalDate timestamp;

    private String message;

    private String details;



}
