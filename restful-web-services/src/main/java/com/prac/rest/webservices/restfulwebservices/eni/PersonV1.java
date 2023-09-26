package com.prac.rest.webservices.restfulwebservices.eni;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonV1 {
     private String name;

}
