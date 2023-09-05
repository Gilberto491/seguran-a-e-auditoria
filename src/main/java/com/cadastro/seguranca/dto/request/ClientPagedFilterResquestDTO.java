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

    Long cdClient;
    String email;
    String name;
    public final CivilStatus status;

}
