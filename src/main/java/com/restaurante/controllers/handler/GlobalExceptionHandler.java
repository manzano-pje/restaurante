package com.restaurante.controllers.handler;

import com.restaurante.exceptions.InternalServerErrorException;
import com.restaurante.exceptions.MethodNotSuportedException;
import com.restaurante.exceptions.company.CompanyAlreadyExistsException;
import com.restaurante.exceptions.company.CompanyNotFoundException;
import com.restaurante.exceptions.groups.GroupAlerdyExistExceptioin;
import com.restaurante.exceptions.groups.GroupNotExistException;
import com.restaurante.exceptions.product.ProductAlerdyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<PersonalError> handleInternalServerErrorException(InternalServerErrorException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(CompanyAlreadyExistsException.class)
    public ResponseEntity<PersonalError> handleCompanyAlreadyExistsException(CompanyAlreadyExistsException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<PersonalError> handleCompanyNotFoundException(CompanyNotFoundException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ProductAlerdyExistException.class)
    public ResponseEntity<PersonalError> handleProductAlerdyExistException(ProductAlerdyExistException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(MethodNotSuportedException.class)
    public ResponseEntity<PersonalError> handleMethodNotSuportedException(MethodNotSuportedException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(GroupAlerdyExistExceptioin.class)
    public ResponseEntity<PersonalError> handleGroupAlerdyExistExceptioin(GroupAlerdyExistExceptioin ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(GroupNotExistException.class)
    public ResponseEntity<PersonalError> handleGroupNotExistException(GroupNotExistException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
