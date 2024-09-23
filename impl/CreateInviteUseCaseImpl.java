package com.Invitemee.Invitemee.impl;

import com.Invitemee.Invitemee.gateway.CreateInviteGateway;
import com.Invitemee.Invitemee.infra.entity.Invite;
import com.Invitemee.Invitemee.infra.exception.InviteException;
import com.Invitemee.Invitemee.usecase.CreateInviteUseCase;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class CreateInviteUseCaseImpl implements CreateInviteUseCase {

    private final CreateInviteGateway createInviteGateway;

    public CreateInviteUseCaseImpl(CreateInviteGateway createInviteGateway) {
        this.createInviteGateway = createInviteGateway;
    }

    @Override
    public String createInvite(Invite invite, List<MultipartFile> imageFiles) throws InviteException, IOException {
        // Some validations
        return this.createInviteGateway.createInvite(invite,imageFiles);
    }
}
