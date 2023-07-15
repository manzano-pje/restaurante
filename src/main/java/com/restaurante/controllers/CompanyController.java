package com.restaurante.controllers;

import com.restaurante.record.CompanyRecord;
import com.restaurante.services.CompanyServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v01/company")
public class CompanyController {

    private final CompanyServices companyServices;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CompanyRecord companyRecord) {
        companyServices.create(companyRecord);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(companyRecord.id()).toUri();

        // não está buscando id cadastrado

        return ResponseEntity.created(uri).body("Company created.");
    }

    @GetMapping
    public ResponseEntity<List<CompanyRecord>> list(){
        List<CompanyRecord> lista = companyServices.list();
        return ResponseEntity.ok().body(lista);
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody CompanyRecord companyRecord) {
        companyServices.update(companyRecord);
        return ResponseEntity.ok().body("The company has been updated.");

    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<String> deleteCompany(@PathVariable String cnpj) {
        companyServices.delete(cnpj);
        return ResponseEntity.noContent().build();
    }
}
