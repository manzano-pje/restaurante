package com.restaurante.middleware;


import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ErrorResponse extends RuntimeException{
    private String mensagem;
    private Integer codigo;

    public ErrorResponse(String mensagem, Integer codigo){
        this.mensagem = mensagem;
        this.codigo = codigo;
    }
    public Map<String, List<String>> paraJson(){
        Map<String, List<String>> json = new HashMap<>();
        List<String> errors = new ArrayList<>();
        errors.add(mensagem);
        json.put("erros", errors);
        return json;
    }
}

