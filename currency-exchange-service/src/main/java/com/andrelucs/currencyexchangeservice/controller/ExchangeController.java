package com.andrelucs.currencyexchangeservice.controller;

import com.andrelucs.currencyexchangeservice.data.CurrencyExchange;
import com.andrelucs.currencyexchangeservice.exception.UnmappedExchangeException;
import com.andrelucs.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    private final Environment environment;

    private final CurrencyExchangeRepository exchangeRepository;

    public ExchangeController(Environment environment, CurrencyExchangeRepository exchangeRepository) {
        this.environment = environment;
        this.exchangeRepository = exchangeRepository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to
    ){
        CurrencyExchange currencyExchange = exchangeRepository.findByFromAndTo(from, to);
        if(currencyExchange == null){
            throw new UnmappedExchangeException("Unable to find data for " + from + " to " + to);
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

}
