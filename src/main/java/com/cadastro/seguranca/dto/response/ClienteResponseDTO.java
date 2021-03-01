package com.cadastro.seguranca.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponseDTO {

    private Long cdCliente;
    private String telefone;
    private String nomeCompleto;
    private String senha;
}
