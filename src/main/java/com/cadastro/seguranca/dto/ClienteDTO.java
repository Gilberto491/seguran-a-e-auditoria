package com.cadastro.seguranca.dto;

import com.cadastro.seguranca.po.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long cdCliente;
    private String telefone;
    private String email;
    private String nomeCompleto;
    private String senha;

    public ClienteDTO(Cliente cliente) {
        this.cdCliente = cliente.getCdCliente();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.senha = cliente.getSenha();
    }

}
