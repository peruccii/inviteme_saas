package com.Invitemee.Invitemee.service;

import com.Invitemee.Invitemee.stripe.handleStripeWebhook.inviteTypeConstants.InviteTypeConstants;
import com.Invitemee.Invitemee.usecase.SendEmailUseCase;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService implements SendEmailUseCase {

    @Override
    public void sendEmailUseCase(String email, String inviteType) {
        Resend resend = new Resend("re_h82aX9cr_Kbaz5jRkoZU42Argr5yY8kK5"); // api key

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("Acme <onboarding@resend.dev>")
                .to("delivered@resend.dev")
                .subject("COMPRA REALIZADA")
                .html(checkType(inviteType))
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            // replace with more robust logging
            e.printStackTrace();
        }
    }
    public String checkType(String inviteType) {
        String qrCodeUrl = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=https://sgc.cidic.com.br";
        return switch (inviteType) {
            case "LOVE" -> InviteTypeConstants.getLoveContent(qrCodeUrl);
            case "BIRTHDAY" -> InviteTypeConstants.getBirthdayContent(qrCodeUrl);
            case "MARRIAGE" -> InviteTypeConstants.getMarriageContent(qrCodeUrl);
            default -> throw new IllegalStateException("Unexpected value: " + inviteType);
        };
    }
}
