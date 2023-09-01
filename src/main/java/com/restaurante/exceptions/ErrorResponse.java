package com.restaurante.exceptions;


import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ErrorResponse extends RuntimeException {
    private String mensagem;
    private Integer codigo;

    public ErrorResponse(String mensagem, Integer codigo) {
        this.mensagem = mensagem;
        this.codigo = codigo;
    }

    public Map<String, List<String>> paraJson() {
        Map<String, List<String>> json = new HashMap<>();
        List<String> errors = new ArrayList<>();
        errors.add(mensagem);
        json.put("erros", errors);
        return json;
    }
}
//}
//
//@Data
//public class ErrorResponse extends RuntimeException{
//    private String message;
//    private Integer code;
//
//    public ErrorResponse(String message, Integer code){
//        this.message = message;
//        this.code = code;
//    }
//
//    public Map<String, Object> paraJson() {
//        Map<String, Object> json = new HashMap<>();
//        json.put("erro", code);
//        json.put("mensagem", message);
//        return json;
//    }
//}

