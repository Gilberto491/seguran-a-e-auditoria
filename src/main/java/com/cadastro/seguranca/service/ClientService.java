package com.cadastro.seguranca.service;

import com.cadastro.seguranca.dto.ClientDTO;
import com.cadastro.seguranca.dto.request.ClientPagedFilterResquestDTO;
import com.cadastro.seguranca.dto.response.ClientResponseDTO;
import com.cadastro.seguranca.po.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    void save(ClientDTO clientDTO);

    ClientResponseDTO search(Long cdClient);

    Page<Client> findPagedByFilters(
            ClientPagedFilterResquestDTO filter,
            Pageable pageable);

    void delete(Long cdClient);

    void edit(Long cdClient, ClientDTO clientDTO);

}
