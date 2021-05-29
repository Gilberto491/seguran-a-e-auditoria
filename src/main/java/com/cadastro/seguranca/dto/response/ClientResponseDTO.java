package com.cadastro.seguranca.dto.response;

import com.cadastro.seguranca.po.enumerations.CivilStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponseDTO {

    private Long cdClient;
    private String telephone;
    private String name;
    private String password;
    private CivilStatus status;

}
