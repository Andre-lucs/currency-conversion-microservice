package com.andrelucs.currencyconversionservice.service;

import com.andrelucs.currencyconversionservice.data.CurrencyExchangeResponse;
import com.andrelucs.currencyconversionservice.exception.NotFoundException;
import com.andrelucs.currencyconversionservice.service.proxy.CurrencyExhangeProxy;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {

    private final CurrencyExhangeProxy currencyExhangeProxy;

    public CurrencyConversionService(CurrencyExhangeProxy currencyExhangeProxy) {
        this.currencyExhangeProxy = currencyExhangeProxy;
    }

    public CurrencyExchangeResponse retrieveExchangeValue(String from, String to) {
        var response = currencyExhangeProxy.getExchangeValue(from, to);
        if (response == null) {
            throw new NotFoundException("Unable to find data for " + from + " to " + to);
        }
        return response;
    }
}
