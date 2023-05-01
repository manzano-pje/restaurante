package com.restaurante.exceptions;

public class UsuarioNaoCadastrado extends ErrorResponse{
    public UsuarioNaoCadastrado(){
        super("Não existem usuários cadastrados.", 404);
    }
}
