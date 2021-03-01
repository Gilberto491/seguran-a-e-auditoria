package com.cadastro.seguranca.service.impl;

import com.cadastro.seguranca.dto.ClienteDTO;
import com.cadastro.seguranca.dto.response.ClienteResponseDTO;
import com.cadastro.seguranca.mapper.ClienteResponseMapper;
import com.cadastro.seguranca.po.Cliente;
import com.cadastro.seguranca.repositories.ClienteRepository;
import com.cadastro.seguranca.service.ClienteService;
import com.cadastro.seguranca.utils.AdicionarCriptografia;
import io.netty.handler.codec.MessageAggregationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {
       try {
           Cliente cliente = new Cliente();
           AdicionarCriptografia adicionarCriptografia = new AdicionarCriptografia();
           cliente.setEmail(clienteDTO.getEmail());
           cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
           cliente.setTelefone(clienteDTO.getTelefone());
           cliente.setSenha(adicionarCriptografia.criptografar(clienteDTO.getSenha()));
           ClienteDTO newDTO = new ClienteDTO(repository.saveAndFlush(cliente));
           return newDTO;
       }catch (Exception e) {
           throw new RuntimeException();
       }
    }

    @Override
    public ClienteResponseDTO buscarClienteEspecifico(Long cdCliente) {
        try {
            Cliente cliente = repository.findById(cdCliente).get();
            return new ClienteResponseMapper().apply(cliente);
        }catch (Exception e) {
            throw new MessageAggregationException(e.getMessage().concat(" *id não encontrado*"));
        }
    }

    @Override
    public ClienteResponseDTO editarCliente(Long cdCliente, ClienteDTO clienteDTO) {
       try {
           ModelMapper mapper = new ModelMapper();
           mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
           Cliente cliente = mapper.map(clienteDTO, Cliente.class);

           findById(cdCliente);

           cliente.setCdCliente(cdCliente);
           repository.saveAndFlush(cliente);
           return new ClienteResponseMapper().apply(cliente);
       } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
       }
    }

    private Cliente findById(Long cdCliente) {
        return repository.findById(cdCliente).get();
    }

}
