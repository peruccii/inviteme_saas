package com.Invitemee.Invitemee.infra.exception.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    ON0001("YOUTUBE URL IS NOT VALID", "ON-0001"),
    BA0001("INVITE OF TYPE PLAN BASIC CANNOT SELECT 3+ PHOTOS", "BA-0001"),
    PR0001("INVITE OF TYPE PLAN PREMIUM CANNOT SELECT 7+ PHOTOS", "PR-0001"),

    ;

    private final String message;

    private final String code;


    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }
}

