package com.restaurante.controllers;

import com.restaurante.dtos.CompanyDto;
import com.restaurante.services.CompanyServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/company")
public class CompanyController {

    private final CompanyServices companyServices;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CompanyDto companyDto) {
        CompanyDto retorno = companyServices.create(companyDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(retorno.getId()).toUri();
        return ResponseEntity.created(uri).body("Company created.");
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> list(){
        List<CompanyDto> lista = companyServices.list();
        return ResponseEntity.ok().body(lista);
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody CompanyDto companyDto) {
        companyServices.update(companyDto);
        return ResponseEntity.ok().body("The company has been updated.");

    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<String> deleteCompany(@PathVariable String cnpj) {
        companyServices.delete(cnpj);
        return ResponseEntity.noContent().build();
    }
}
