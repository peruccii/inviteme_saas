package com.Invitemee.Invitemee.usecase;

import com.Invitemee.Invitemee.infra.exception.BadRequestException;
import com.Invitemee.Invitemee.infra.exception.NotFoundException;
import com.stripe.model.Event;

public interface EventsTypeStripeUseCase {
    void completed(Event event) throws NotFoundException, BadRequestException;
    void failed(Event event);
}
