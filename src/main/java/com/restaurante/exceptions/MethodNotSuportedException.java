package com.restaurante.exceptions;

public class MethodNotSuportedException extends ErrorResponse {
    public MethodNotSuportedException(){
        super("Error deleting company.", 405);
    }
}
