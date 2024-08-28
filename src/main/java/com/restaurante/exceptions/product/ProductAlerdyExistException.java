package com.restaurante.exceptions.product;

import com.restaurante.exceptions.ErrorResponse;

public class ProductAlerdyExistException extends ErrorResponse {
    public ProductAlerdyExistException(){
        super("Product alerdy exist.", 409);
    }
}
