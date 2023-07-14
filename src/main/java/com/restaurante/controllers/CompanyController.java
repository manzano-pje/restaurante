package com.restaurante.controllers;

import com.restaurante.dtos.CompanyDto;
import com.restaurante.exceptions.CompanyExistException;
import com.restaurante.exceptions.CompanyNotFoundException;
import com.restaurante.exceptions.InternalServerErrorException;
import com.restaurante.services.CompanyServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v01/company")
public class CompanyController {

    private final CompanyServices companyServices;

    @PostMapping
    public ResponseEntity<Object> createCompany(@RequestBody CompanyDto companyDto)
            throws CompanyExistException, InternalServerErrorException {
        companyServices.createCompany(companyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company created.");
    }

    @GetMapping
    public ResponseEntity<Object> listCompany(){
        List<CompanyDto> lista = companyServices.listCompany();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PatchMapping
    public ResponseEntity<Object> updateCompany(@RequestBody CompanyDto companyDto) {
        companyServices.updateCompany(companyDto);
        return ResponseEntity.status(HttpStatus.OK).body("The company has been updated.");

    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCompany() {
        companyServices.deleteCompany();
        return ResponseEntity.status(HttpStatus.OK).body("Company is deleted.");
    }
}
