package com.restaurante.controllers.handler;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseException extends RuntimeException {
    private final Integer code;
    private final String message;

    public ErrorResponseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {return message;}

    public Map<String, Object> paraJson() {
        Map<String, Object> json = new HashMap<>();
        json.put("erro", code);
        json.put("mensagem", message);
        return json;
    }
}



