package com.restaurante.record;

import com.restaurante.entities.Company;

public record CompanyRecord(
        String cnpj,
        String stateReg,
        String name,
        String adress,
        String neighborhood,
        String city,
        String uf,
        String zipCode,
        String phone,
        String cellPhone,
        String email,
        String logo
){
    public CompanyRecord(Company company) {
       this(company.getCnpj(),
            company.getStateReg(),
            company.getName(),
            company.getAdress(),
            company.getNeighborhood(),
            company.getCity(),
            company.getUf(),
            company.getZipCode(),
            company.getPhone(),
            company.getCellPhone(),
            company.getEmail(),
            company.getLogo());
    }
}
