package com.cadastro.seguranca.service.impl;

import com.cadastro.seguranca.dto.ClientDTO;
import com.cadastro.seguranca.dto.request.ClientPagedFilterResquestDTO;
import com.cadastro.seguranca.dto.response.ClientResponseDTO;
import com.cadastro.seguranca.mapper.ClientResponseMapper;
import com.cadastro.seguranca.po.Client;
import com.cadastro.seguranca.repositories.ClientRepository;
import com.cadastro.seguranca.service.ClientService;
import com.cadastro.seguranca.utils.AddCrypt;
import io.netty.handler.codec.MessageAggregationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public void save(ClientDTO clientDTO) {
       try {

            setClient(clientDTO);

       }catch (Exception e) {
           throw new RuntimeException(e.getMessage());
       }
    }

    @Override
    public ClientResponseDTO search(Long cdClient) {
        try {
            Client client = repository.findById(cdClient).get();
            return new ClientResponseMapper().apply(client);
        }catch (Exception e) {
            throw new MessageAggregationException(e.getMessage().concat(" *id não encontrado*"));
        }
    }

    @Override
    public void edit(Long cdClient, ClientDTO clientDTO) {
       Client client = findById(cdClient);

       client.setEmail(clientDTO.getEmail());
       client.setName(clientDTO.getName());
       client.setPassword(clientDTO.getPassword());
       client.setStatus(clientDTO.getStatus());
       client.setTelephone(clientDTO.getTelephone());
       repository.saveAndFlush(client);
    }

    @Override
    public Page<Client> findPagedByFilters(ClientPagedFilterResquestDTO filter, Pageable pageable) {
        if(ObjectUtils.isEmpty(filter)) {
            throw new MessageAggregationException("Pelo Menos um filtro deve ser enviado");
        }
        return repository.findFilterList(filter, pageable);
    }

    @Override
    public void delete(Long cdClient) {
        repository.deleteById(cdClient);
    }

    private Client findById(Long cdClient) {
        return repository.findById(cdClient).get();
    }

    private void setClient(ClientDTO clientDTO) {
        Client client = new Client();
        AddCrypt addCrypt = new AddCrypt();
        client.setEmail(clientDTO.getEmail());
        client.setName(clientDTO.getName());
        client.setTelephone(clientDTO.getTelephone());
        client.setStatus(clientDTO.getStatus());
        client.setPassword(addCrypt.crypt(clientDTO.getPassword()));
        repository.saveAndFlush(client);
    }
}
