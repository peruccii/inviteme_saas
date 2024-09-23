package com.Invitemee.Invitemee.controller;


import com.Invitemee.Invitemee.infra.entity.Invite;
import com.Invitemee.Invitemee.infra.exception.InviteException;
import com.Invitemee.Invitemee.usecase.CreateInviteUseCase;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/")
public class InviteController {

    private final CreateInviteUseCase createInviteUseCase;

    public InviteController(CreateInviteUseCase createInviteUseCase) {
        this.createInviteUseCase = createInviteUseCase;
    }

    @PostMapping(value = "/create_invite", consumes = {"multipart/form-data"})
    public String createInvite(@RequestPart("invite_payload") Invite invite_payload, @RequestPart(value = "images", required = false) List<MultipartFile> imageFiles) throws InviteException, IOException {
        return createInviteUseCase.createInvite(invite_payload, imageFiles);
    }
}
