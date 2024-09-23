package com.Invitemee.Invitemee.infra.entity;

import lombok.Getter;

@Getter
public enum InvitePlan {

    BASIC(9.99, 3),
    PREMIUM(19.99,  7)
    ;

    private final double price;

    private final Integer quantity_photos;


    InvitePlan(double price, Integer quantity_photos) {
        this.price = price;
        this.quantity_photos = quantity_photos;
    }
}
