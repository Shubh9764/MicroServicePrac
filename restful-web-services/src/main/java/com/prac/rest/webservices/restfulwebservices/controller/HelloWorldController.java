package com.prac.rest.webservices.restfulwebservices.controller;

import com.prac.rest.webservices.restfulwebservices.entities.HelloWorld;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @GetMapping("/hi")
    public String greet(){
        return "hello world";
    }

    @GetMapping("/hi-bean")
    public HelloWorld greetBean(){
        return new HelloWorld("Hello World Bean");
    }
    @GetMapping("/hi/{name}")
    public HelloWorld greetName(@PathVariable String name){
        return new HelloWorld("Hello "+ name );
    }

    @GetMapping("/hello")
    public String greetHello(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morni",null,"Defalut Message",locale);
    }
}
