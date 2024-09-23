package com.Invitemee.Invitemee.service;

import com.Invitemee.Invitemee.gateway.CreateInviteGateway;
import com.Invitemee.Invitemee.infra.entity.Invite;
import com.Invitemee.Invitemee.infra.entity.InvitePlan;
import com.Invitemee.Invitemee.infra.exception.InviteException;
import com.Invitemee.Invitemee.infra.exception.enums.ErrorCodeEnum;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateInviteService implements CreateInviteGateway {

    private final FirebaseService firebaseService;
    private final CreateStripeCheckoutSession createStripeCheckoutSession;

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    public CreateInviteService(FirebaseService firebaseService, CreateStripeCheckoutSession createStripeCheckoutSession) {
        this.firebaseService = firebaseService;
        this.createStripeCheckoutSession = createStripeCheckoutSession;
        Stripe.apiKey = stripeApiKey;
    }

    @Override
    public String createInvite(Invite invite, List<MultipartFile> imageFiles) throws InviteException, IOException {

        // Change this to a mapper or a builder
       var inviteRaw = new Invite();
       inviteRaw.setInvite_name(invite.getInvite_name());
       inviteRaw.setEmail(invite.getEmail());
       inviteRaw.setUrlMusic(invite.getUrlMusic());
       inviteRaw.setInvite_name(invite.getInvite_name());
       inviteRaw.setText(invite.getText());
       inviteRaw.setInvited_name(invite.getInvited_name());
       inviteRaw.setInvite_type(invite.getInvite_type());
       inviteRaw.setInvitePlan(invite.getInvitePlan());

        if (inviteRaw.getImageUrls() == null) {
            inviteRaw.setImageUrls(new ArrayList<>());
        }

        // Separate
        if (inviteRaw.getInvitePlan().equals(InvitePlan.BASIC) && inviteRaw.getImageUrls().size() > 3) throw new InviteException(
                ErrorCodeEnum.BA0001.getMessage(),
                ErrorCodeEnum.BA0001.getCode()
        );

        // Separate
        if (inviteRaw.getInvitePlan().equals(InvitePlan.PREMIUM) && inviteRaw.getImageUrls().size() > 7) throw new InviteException(
                ErrorCodeEnum.PR0001.getMessage(),
                ErrorCodeEnum.PR0001.getCode()
        );

        // Separate
        if(!inviteRaw.isUrlMusicCorrect(invite.getUrlMusic())) {
            throw new InviteException(
                    ErrorCodeEnum.ON0001.getMessage(),
                    ErrorCodeEnum.ON0001.getCode()
            );
        }

        List<String> imageUrls = this.firebaseService.uploadImages(imageFiles, invite.getEmail());
        invite.setImageUrls(imageUrls);

        String paymentUrl = this.createStripeCheckoutSession.createStripeCheckoutSession(inviteRaw);
        System.out.println("aaaaaaaaaa");

        return paymentUrl;
    }

}
