package com.andrelucs.currencyconversionservice.service.proxy;

import com.andrelucs.currencyconversionservice.data.CurrencyExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "currency-exchange")
public interface CurrencyExhangeProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResponse getExchangeValue(@PathVariable String from, @PathVariable String to);
}
