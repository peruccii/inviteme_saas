package com.Invitemee.Invitemee.convert;

import com.Invitemee.Invitemee.infra.entity.Invite;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InviteConvert {

    public Invite forInviteEntity(Invite invite){
        return Invite.builder()
                .invited_name(invite.getInvited_name())
                .email(invite.getEmail())
                .invite_name(invite.getInvite_name())
                .text(invite.getText())
                .imageUrls(invite.getImageUrls())
                .build();
    }
}
