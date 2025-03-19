package com.andrelucs.currencyconversionservice.data;

import java.math.BigDecimal;

public class CurrencyExchangeResponse {
    private Long id;
    private String from;
    private String to;
    private BigDecimal convertionMultiple;
    private String environment;
    public CurrencyExchangeResponse() {
    }

    public CurrencyExchangeResponse(Long id, String from, String to, BigDecimal convertionMultiple, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.convertionMultiple = convertionMultiple;
        this.environment = environment;
    }

    public BigDecimal getConvertionMultiple() {
        return convertionMultiple;
    }

    public void setConvertionMultiple(BigDecimal convertionMultiple) {
        this.convertionMultiple = convertionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
