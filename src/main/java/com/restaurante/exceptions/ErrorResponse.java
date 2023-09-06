package com.restaurante.exceptions;


import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ErrorResponse extends RuntimeException {
    private String message;
    private Integer code;

    public ErrorResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public Map<String, List<String>> paraJson() {
        Map<String, List<String>> json = new HashMap<>();
        List<String> errors = new ArrayList<>();
        errors.add(message);
        json.put("erros", errors);
        return json;
    }
}

