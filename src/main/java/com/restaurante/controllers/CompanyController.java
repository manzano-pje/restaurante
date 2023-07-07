package com.restaurante.controllers;

import com.restaurante.dtos.CompanyDto;
import com.restaurante.services.CompanyServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v01/company")
public class CompanyController {

    private final CompanyServices companyServices;

    @PostMapping
    public ResponseEntity<Object> createCompany(@RequestBody CompanyDto companyDto) {
        return companyServices.createCompany(companyDto);
    }

    @GetMapping
    public ResponseEntity<Object> listCompany(){
        return companyServices.listCompany();
    }

    @PatchMapping
    public ResponseEntity<Object> updateCompany(@RequestBody CompanyDto companyDto){
        return companyServices.updateCompany(companyDto);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCompany(){
        return companyServices.deleteCompany();
    }
}
