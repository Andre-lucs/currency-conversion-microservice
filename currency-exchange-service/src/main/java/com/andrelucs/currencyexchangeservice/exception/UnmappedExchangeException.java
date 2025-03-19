package com.andrelucs.currencyexchangeservice.exception;

public class UnmappedExchangeException extends RuntimeException {
    public UnmappedExchangeException(String message) {
        super(message);
    }
}
