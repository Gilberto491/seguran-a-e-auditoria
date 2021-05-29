package com.cadastro.seguranca.dto.request;

import com.cadastro.seguranca.po.enumerations.CivilStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientPagedFilterResquestDTO {

    private Long cdClient;
    private String email;
    private String name;
    public CivilStatus status;

}
