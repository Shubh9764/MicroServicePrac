package com.prac.rest.webservices.restfulwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.prac.rest.webservices.restfulwebservices.entities.Somebean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;


@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        Somebean somebean = new Somebean("a","b","c");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean);
        FilterProvider filter = new SimpleFilterProvider().addFilter("SomeBeanFilter",SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2"));
        mappingJacksonValue.setFilters(filter);
        return mappingJacksonValue;
    }
    @GetMapping("/filterings")
    public MappingJacksonValue filterings(){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(Arrays.asList(new Somebean("a","b","c"),
                new Somebean("d","e","f")));
        FilterProvider filter = new SimpleFilterProvider().addFilter("SomeBeanFilter",SimpleBeanPropertyFilter.serializeAll());
        mappingJacksonValue.setFilters(filter);
        return mappingJacksonValue;
    }
}
