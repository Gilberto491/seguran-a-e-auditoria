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

    Long cdClient;
    String telephone;
    String email;
    String name;
    String password;
    CivilStatus status;

}
