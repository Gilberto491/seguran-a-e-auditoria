package com.cadastro.seguranca.resources;

import com.cadastro.seguranca.dto.ClientDTO;
import com.cadastro.seguranca.dto.request.ClientPagedFilterResquestDTO;
import com.cadastro.seguranca.dto.response.ClientResponseDTO;
import com.cadastro.seguranca.po.Client;
import com.cadastro.seguranca.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/client")
@Validated
@RequiredArgsConstructor
public class ClientResource {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Validated ClientDTO clientDTO) {
        HttpHeaders headers = new HttpHeaders();
        service.save(clientDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{cdClient}")
    public ClientResponseDTO search(@PathVariable Long cdClient) {
        return service.search(cdClient);
    }

    @PutMapping("/{cdClient}")
    public void edit(@PathVariable Long cdClient, @RequestBody ClientDTO clientDTO) {
        service.edit(cdClient, clientDTO);
    }

    @DeleteMapping("/{cdClient}")
    public void delete(@PathVariable Long cdClient) {
        service.delete(cdClient);
    }

    @GetMapping("/filter")
    public Page<Client> findPagedByFilter(
            @RequestBody ClientPagedFilterResquestDTO filter,
            Pageable pageable) {
        return service.findPagedByFilters(filter, pageable);
    }

}
