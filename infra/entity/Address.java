package com.Invitemee.Invitemee.infra.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class Address {
    private String cep;
    private String numero;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String cidade;
}
