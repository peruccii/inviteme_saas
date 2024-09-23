package com.Invitemee.Invitemee.usecase;

import com.Invitemee.Invitemee.infra.entity.Invite;
import com.Invitemee.Invitemee.infra.exception.InviteException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CreateInviteUseCase {
    String createInvite(Invite invite, List<MultipartFile> imageFiles) throws InviteException, IOException;
}
