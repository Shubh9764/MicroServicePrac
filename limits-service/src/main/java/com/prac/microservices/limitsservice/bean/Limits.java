package com.prac.microservices.limitsservice.bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Limits {
    private int minimum;
    private  int maximum;
}
