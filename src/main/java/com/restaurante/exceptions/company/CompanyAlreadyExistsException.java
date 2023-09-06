package com.restaurante.exceptions.company;

import com.restaurante.exceptions.ErrorResponse;

public class CompanyAlreadyExistsException extends ErrorResponse {
    public CompanyAlreadyExistsException() {

        super("There is already a registered company.", 409);
    }
}
