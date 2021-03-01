package com.cadastro.seguranca.po;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Cliente {

    @Id
    @SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ")
    @GeneratedValue( generator = "CLIENTE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long cdCliente;

    private String telefone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private String senha;

}
