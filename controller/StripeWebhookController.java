package com.Invitemee.Invitemee.controller;

import com.Invitemee.Invitemee.infra.exception.BadRequestException;
import com.Invitemee.Invitemee.infra.exception.NotFoundException;
import com.Invitemee.Invitemee.stripe.handleStripeWebhook.HandleStripeWebhooks;
import com.Invitemee.Invitemee.usecase.SendEmailUseCase;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stripe")
public class StripeWebhookController {

    private final HandleStripeWebhooks handleStripeWebhooks;
    private final SendEmailUseCase sendEmailUseCase;
    public StripeWebhookController(HandleStripeWebhooks handleStripeWebhooks, SendEmailUseCase sendEmailUseCase) {
        this.handleStripeWebhooks = handleStripeWebhooks;
        this.sendEmailUseCase = sendEmailUseCase;
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) throws NotFoundException, BadRequestException {
        Event event;
        try {
            event = Webhook.constructEvent(payload, sigHeader, "whsec_3952a68fe3c7b4972c97ebe9ed7e0e70b1179cc5c5ae26f1d6c7f8632ad267b6");
        } catch (SignatureVerificationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid signature");
        }

        if ("checkout.session.completed".equals(event.getType())) {
            Session session = (Session) event.getDataObjectDeserializer().getObject().orElse(null);

            sendEmailUseCase.sendEmailUseCase("aa", session.getMetadata().get("inviteType"));
            // this part is not working
//            if (session != null) {
//                String inviteId = session.getMetadata().get("inviteId");
//                if (inviteId != null) {
//                    Invite invite = inviteRepository.findById(inviteId).orElse(null);
//                    if (invite != null) {
//                        inviteRepository.save(invite);
//                        sendEmailUseCase.sendEmailUseCase(session.getCustomerDetails().getEmail(), session.getMetadata().get("inviteType"));
//                    } else {
//                         throw new NotFoundException(
//                                 ErrorCodeEnum.BA0001.getMessage(),
//                                 ErrorCodeEnum.ON0001.getCode()
//                         );
//                    }
//                } else {
//                    throw new BadRequestException(
//                            ErrorCodeEnum.BA0001.getMessage(),
//                            ErrorCodeEnum.ON0001.getCode()
//                    );
//                }
//            }
        }

        handleStripeWebhooks.failed(event);

        return ResponseEntity.ok("Webhook handled");
    }
}
