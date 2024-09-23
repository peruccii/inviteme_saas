package com.Invitemee.Invitemee.gateway;

import com.Invitemee.Invitemee.infra.entity.Invite;
import com.Invitemee.Invitemee.infra.exception.InviteException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CreateInviteGateway {
    String createInvite(Invite invite, List<MultipartFile> imageFiles) throws InviteException, IOException;
}
