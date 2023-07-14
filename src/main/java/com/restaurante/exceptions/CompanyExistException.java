package com.restaurante.exceptions;

import com.restaurante.middleware.ErrorResponse;

public class CompanyExistException extends ErrorResponse {
    public CompanyExistException() {
         super("Company already exists", 409);
    }
}
