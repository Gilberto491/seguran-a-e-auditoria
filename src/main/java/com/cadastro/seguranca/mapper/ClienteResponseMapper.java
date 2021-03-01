package com.cadastro.seguranca.mapper;

import com.cadastro.seguranca.dto.response.ClienteResponseDTO;
import com.cadastro.seguranca.po.Cliente;

import java.util.function.Function;

public  final class ClienteResponseMapper implements Function<Cliente, ClienteResponseDTO> {

    @Override
    public ClienteResponseDTO apply(final Cliente cliente) {
        return ClienteResponseDTO
                .builder()
                .cdCliente(cliente.getCdCliente())
                .nomeCompleto(cliente.getNomeCompleto())
                .senha(cliente.getSenha())
                .telefone(cliente.getTelefone())
                .build();
    }
}
