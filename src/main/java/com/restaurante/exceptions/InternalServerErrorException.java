package com.restaurante.exceptions;

import com.restaurante.middleware.ErrorResponse;

public class InternalServerErrorException extends ErrorResponse {
    public InternalServerErrorException(){
        super("Internal Server Error", 500);
    }
}
