package com.andrelucs.currencyconversionservice.controller;

import com.andrelucs.currencyconversionservice.data.CurrencyConversion;
import com.andrelucs.currencyconversionservice.data.CurrencyExchangeResponse;
import com.andrelucs.currencyconversionservice.service.CurrencyConversionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    @RateLimiter(name = "default")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyExchangeResponse currencyExchangeResponse = currencyConversionService.retrieveExchangeValue(from, to);
        
        return new CurrencyConversion(currencyExchangeResponse.getId(), from, to, currencyExchangeResponse.getConvertionMultiple(), 
                quantity, quantity.multiply(currencyExchangeResponse.getConvertionMultiple()), currencyExchangeResponse.getEnvironment());
    }

    public CurrencyConversion fallback(String from, String to, BigDecimal quantity, Exception e) {
        return new CurrencyConversion(0L, from, to, BigDecimal.ZERO, quantity, BigDecimal.ZERO, "Fallback");
    }

}
