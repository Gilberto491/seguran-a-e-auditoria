package com.cadastro.seguranca.dto;

import com.cadastro.seguranca.po.enumerations.CivilStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long cdClient;
    private String telephone;
    private String email;
    private String name;
    private String password;
    private CivilStatus status;

}
