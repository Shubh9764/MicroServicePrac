package com.prac.rest.webservices.restfulwebservices.controller;

import com.prac.rest.webservices.restfulwebservices.eni.PersonV1;
import com.prac.rest.webservices.restfulwebservices.eni.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionPerson(){
        return new PersonV1("Bob Charli");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionPerson(){
        return new PersonV2("Bob","Charli");
    }
    @GetMapping(value = "/person",params = "version=1")
    public PersonV1 getPersonRequestV1(){
        return new PersonV1("Bob Charli");
    }
    @GetMapping(value = "/person",params = "version=2")
    public PersonV2 getPersonRequestV2(){
        return new PersonV2("Bob","Charli");
    }

    @GetMapping(value = "/person",headers = "X-API-VERSION=1")
    public PersonV1 getPersonRequestHeaderV1(){
        return new PersonV1("Bob Charli");
    }
    @GetMapping(value = "/person",headers = "X-API-VERSION=2")
    public PersonV2 getPersonRequestHeaderV2(){
        return new PersonV2("Bob","Charli");
    }

    @GetMapping(value = "/person",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonAcceptHeaderV1(){
        return new PersonV1("Bob Charli");
    }
    @GetMapping(value = "/person",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonAcceptHeaderV2(){
        return new PersonV2("Bob","Charli");
    }
}
