package com.cadastro.seguranca.mapper;

import com.cadastro.seguranca.dto.response.ClientResponseDTO;
import com.cadastro.seguranca.po.Client;

import java.util.function.Function;

public final class ClientResponseMapper implements Function<Client, ClientResponseDTO> {

    @Override
    public ClientResponseDTO apply(final Client client) {
        return ClientResponseDTO
                .builder()
                .cdClient(client.getCdClient())
                .telephone(client.getTelephone())
                .name(client.getName())
                .password(client.getPassword())
                .status(client.getStatus())
                .build();
    }
}
