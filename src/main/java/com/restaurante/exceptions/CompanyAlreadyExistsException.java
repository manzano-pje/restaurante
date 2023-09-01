package com.restaurante.exceptions;

import com.restaurante.exceptions.ErrorResponse;

public class CompanyAlreadyExistsException extends ErrorResponse {
    public CompanyAlreadyExistsException() {

        super("Company already exists", 409);
    }
}
