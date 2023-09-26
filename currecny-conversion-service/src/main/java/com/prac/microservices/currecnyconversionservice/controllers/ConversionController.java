package com.prac.microservices.currecnyconversionservice.controllers;

import com.prac.microservices.currecnyconversionservice.beans.CurrencyConversion;
import com.prac.microservices.currecnyconversionservice.beans.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class ConversionController {
    @Autowired
    Environment environment;

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable int quantity ){
       CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchange(from,to);
       currencyConversion.setQuantity(BigDecimal.valueOf(quantity));
       currencyConversion.setTotalAmount(currencyConversion.getConversionMultiple().multiply(currencyConversion.getQuantity()));
        return currencyConversion;
    }
}
