package com.restaurante.exceptions;

import com.restaurante.exceptions.ErrorResponse;

public class CompanyNotFoundException extends ErrorResponse {
    public CompanyNotFoundException(){
        super("Company not found", 404);
    }
}
