package com.prac.microservices.currecnyexchangeserviceac.repo;

import com.prac.microservices.currecnyexchangeserviceac.beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepo extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from,String to);
}
