package com.prac.microservices.currecnyexchangeserviceac.controllers;

import com.prac.microservices.currecnyexchangeserviceac.beans.CurrencyExchange;
import com.prac.microservices.currecnyexchangeserviceac.repo.ExchangeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class ExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    ExchangeRepo exchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchnage(@PathVariable String from , @PathVariable String to){
        log.info(" retrieveCurrencyExchnage () : called with {} to {}",from,to);

//       CurrencyExchange currencyExchnage = new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50),environment.getProperty("local.server.port"));
        CurrencyExchange currencyExchnage = exchangeRepo.findByFromAndTo(from, to);
        if (currencyExchnage == null){
            throw  new RuntimeException("Unable to find data for "+from+ " to "+to);
        }
        currencyExchnage.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchnage;
    }
}
