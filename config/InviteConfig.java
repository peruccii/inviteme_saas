package com.Invitemee.Invitemee.config;

import com.Invitemee.Invitemee.gateway.CreateInviteGateway;
import com.Invitemee.Invitemee.impl.CreateInviteUseCaseImpl;
import com.Invitemee.Invitemee.usecase.CreateInviteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InviteConfig {

    @Bean
    public CreateInviteUseCase createInviteUseCase(CreateInviteGateway createInviteGateway){
        return new CreateInviteUseCaseImpl(createInviteGateway);
    }
}
