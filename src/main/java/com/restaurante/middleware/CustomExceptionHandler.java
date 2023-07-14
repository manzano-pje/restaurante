package com.restaurante.middleware;

import com.restaurante.exceptions.InternalServerErrorException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Map<String, List<String>> handleException(Exception exception, HttpServletRequest request, HttpServletResponse response){
        ErrorResponse errorResponse = null;
        if(exception instanceof ErrorResponse){
            errorResponse = (ErrorResponse) exception;
        }else{
            errorResponse = new InternalServerErrorException();
        }
        response.setStatus(errorResponse.getCodigo());
        return errorResponse.paraJson();
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        Map<String, List<String>> json = new HashMap<>();
        List<String> errors = new ArrayList<>();

        for(var error: ex.getBindingResult().getAllErrors()){
            errors.add(error.getDefaultMessage());
        }
        json.put("erros",errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
    }
}
