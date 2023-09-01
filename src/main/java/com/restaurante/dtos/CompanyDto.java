package com.restaurante.dtos;

import com.restaurante.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDto{
    Integer id;
    String cnpj;
    String stateReg;
    String name;
    String adress;
    String neighborhood;
    String city;
    String uf;
    String zipCode;
    String phone;
    String cellPhone;
    String email;

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.cnpj = company.getCnpj();
        this.stateReg = company.getStateReg();
        this.name = company.getName();
        this.adress = company.getAdress();
        this.neighborhood = company.getNeighborhood();
        this.city = company.getCity();
        this.uf = company.getUf();
        this.zipCode = company.getZipCode();
        this.phone = company.getPhone();
        this.cellPhone = company.getCellPhone();
        this.email = company.getEmail();
    }
}