package com.Invitemee.Invitemee.service;

import com.Invitemee.Invitemee.infra.entity.Invite;
import com.Invitemee.Invitemee.infra.entity.InvitePlan;
import com.Invitemee.Invitemee.infra.exception.InviteException;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

@Service
public class CreateStripeCheckoutSession {

    public String createStripeCheckoutSession(Invite invite) throws InviteException {
        try {
            SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl("https://your-app.com/success")
                    .setCancelUrl("https://your-app.com/cancel")
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency("brl")
                                                    .setUnitAmount(getPriceForPlan(invite.getInvitePlan()))
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName("Convite " + invite.getInvite_type() + invite.getInvitePlan())
                                                                    .build()
                                                    )
                                                    .build()
                                    )
                                    .build()
                    )
                    .putMetadata("inviteId", String.valueOf(invite.getId()))
                    .putMetadata("inviteType", invite.getInvite_type().toString())
                    .build();

            Session session = Session.create(params);
            return session.getUrl();

        } catch (StripeException e) {
            throw new InviteException("Failed to create Stripe session: " + e.getMessage(), "STP001");
        }
    }

    private Long getPriceForPlan(InvitePlan plan) {
        return switch (plan) {
            case BASIC -> 1000L; // $10.00
            case PREMIUM -> 2000L; // $20.00
            default -> 1000L; // Valor padrão
        };
    }
}