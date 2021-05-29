package com.cadastro.seguranca.po;

import com.cadastro.seguranca.po.enumerations.CivilStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Client {

    @Id
    @SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ")
    @GeneratedValue( generator = "CLIENT_SEQ", strategy = GenerationType.SEQUENCE)
    private Long cdClient;

    private String telephone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    public CivilStatus status;

}
