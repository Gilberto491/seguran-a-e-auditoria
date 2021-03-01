package com.cadastro.seguranca.service;

import com.cadastro.seguranca.dto.ClienteDTO;
import com.cadastro.seguranca.dto.response.ClienteResponseDTO;

public interface ClienteService {

    ClienteDTO salvarCliente(ClienteDTO clienteDTO);

    ClienteResponseDTO buscarClienteEspecifico(Long cdCliente);

    ClienteResponseDTO editarCliente(Long cdCliente, ClienteDTO clienteDTO);

}
