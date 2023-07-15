package com.restaurante.exceptions;

import com.restaurante.middleware.ErrorResponse;

public class MethodNotSuportedException extends ErrorResponse {
    public MethodNotSuportedException(){
        super("Error deleting company.", 405);
    }
}
