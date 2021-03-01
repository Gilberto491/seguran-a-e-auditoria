package com.cadastro.seguranca.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class AdicionarCriptografia {

    //https://www.alura.com.br/artigos/autenticacao-de-forma-segura-com-criptografia

    public String criptografar(String senha) {
        String salGerado = BCrypt.gensalt();
        return BCrypt.hashpw(senha, salGerado);
    }
}
