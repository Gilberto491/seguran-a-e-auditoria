package com.cadastro.seguranca.resources;

import com.cadastro.seguranca.dto.ClienteDTO;
import com.cadastro.seguranca.dto.response.ClienteResponseDTO;
import com.cadastro.seguranca.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cliente")
@Validated
@RequiredArgsConstructor
public class ClienteResource {

    private final ClienteService service;

    @PostMapping("/salvar-cliente/")
    public ClienteDTO salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        return service.salvarCliente(clienteDTO);
    }

    @GetMapping("/buscar-cliente-especifico/{cdCliente}")
    public ClienteResponseDTO buscarClienteEspecifico(@PathVariable Long cdCliente) {
        return service.buscarClienteEspecifico(cdCliente);
    }

    @PutMapping("/editar-cliente/{cdCliente}")
    public ClienteResponseDTO editarCliente(@PathVariable Long cdCliente, @RequestBody ClienteDTO clienteDTO) {
        return service.editarCliente(cdCliente, clienteDTO);
    }

}
