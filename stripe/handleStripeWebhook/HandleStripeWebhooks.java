package com.Invitemee.Invitemee.stripe.handleStripeWebhook;

import com.Invitemee.Invitemee.infra.entity.Invite;
import com.Invitemee.Invitemee.infra.exception.BadRequestException;
import com.Invitemee.Invitemee.infra.exception.NotFoundException;
import com.Invitemee.Invitemee.infra.exception.enums.ErrorCodeEnum;
import com.Invitemee.Invitemee.infra.repository.InviteRepository;
import com.Invitemee.Invitemee.service.FirebaseService;
import com.Invitemee.Invitemee.usecase.EventsTypeStripeUseCase;
import com.Invitemee.Invitemee.usecase.SendEmailUseCase;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HandleStripeWebhooks implements EventsTypeStripeUseCase {
    private static final Logger logger = LoggerFactory.getLogger(HandleStripeWebhooks.class);

    private final SendEmailUseCase sendEmailUseCase;
    private final InviteRepository inviteRepository;
    private final FirebaseService firebaseService;

    public HandleStripeWebhooks(SendEmailUseCase sendEmailUseCase, InviteRepository inviteRepository, FirebaseService firebaseService) {
        this.sendEmailUseCase = sendEmailUseCase;
        this.inviteRepository = inviteRepository;
        this.firebaseService = firebaseService;
    }


    @Override
    public void completed(Event event) throws NotFoundException, BadRequestException {
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
    }

    @Override
    public void failed(Event event) {
        if ("checkout.session.async_payment_failed".equals(event.getType())) {
            Session session = (Session) event.getDataObjectDeserializer().getObject().orElse(null);
            assert session != null;
            firebaseService.deleteFolder(session.getCustomerDetails().getEmail());
        }
    }
}
