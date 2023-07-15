package com.restaurante.exceptions;

import com.restaurante.middleware.ErrorResponse;

public class CompanyAlreadyExistsException extends ErrorResponse {
    public CompanyAlreadyExistsException() {
         super("Company already exists", 409);
    }
}
