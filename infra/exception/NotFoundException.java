package com.Invitemee.Invitemee.infra.exception;

public class NotFoundException extends Exception {

    private final String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
