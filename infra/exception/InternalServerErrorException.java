package com.Invitemee.Invitemee.infra.exception;

public class InternalServerErrorException extends Exception {

    private final String code;

    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }
}
