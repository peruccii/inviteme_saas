package com.Invitemee.Invitemee.infra.exception;

public class InviteException extends Exception {

    private final String code;

    public InviteException(String message, String code) {
        super(message);
        this.code = code;
    }
}
