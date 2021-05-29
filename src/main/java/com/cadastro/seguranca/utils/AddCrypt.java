package com.cadastro.seguranca.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class AddCrypt {

    //https://www.alura.com.br/artigos/autenticacao-de-forma-segura-com-criptografia

    public String crypt(String password) {
        String generatedSalt = BCrypt.gensalt();
        return BCrypt.hashpw(password, generatedSalt);
    }

}
