package com.Invitemee.Invitemee.controller;

import com.Invitemee.Invitemee.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/charge")
    public String chargeCustomer(@RequestParam String token, @RequestParam double amount) {
        try {
            Charge charge = stripeService.createCharge(token, amount, "usd");
            return "Payment successful. Charge ID: " + charge.getId();
        } catch (StripeException e) {
            return "Error: " + e.getMessage();
        }
    }
}
