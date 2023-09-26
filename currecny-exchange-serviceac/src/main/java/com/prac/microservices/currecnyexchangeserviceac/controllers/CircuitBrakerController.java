package com.prac.microservices.currecnyexchangeserviceac.controllers;

import com.thoughtworks.xstream.annotations.XStreamInclude;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBrakerController {
    @GetMapping("/sample-api")
//    @Retry(name = "sampleapi",fallbackMethod = "fallbackResponse")
    @CircuitBreaker(name = "sampleapi",fallbackMethod = "fallbackResponse")
    @RateLimiter(name = "default")
    public String samplApi(){
        log.info("sampleApi");
//        return new RestTemplate().getForEntity("http://localhost:808/tets",String.class).getBody();
        return "Sample API";
    }
    private String fallbackResponse(Exception ex){
        log.info("fallbackResponse: {}",ex.getMessage());
        return "fallbackResponse";
    }
}
