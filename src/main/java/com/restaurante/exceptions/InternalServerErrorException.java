package com.restaurante.exceptions;

public class InternalServerErrorException extends ErrorResponse {
    public InternalServerErrorException(){
        super("Internal Server Error", 500);
    }
}
