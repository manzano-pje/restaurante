package com.restaurante.dtos;

import com.restaurante.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDto {

        private String cnpj;
        private String stateReg;
        private String name;
        private String adress;
        private String neighborhood;
        private String city;
        private String uf;
        private String zipCode;
        private String phone;
        private String cellPhone;
        private String email;
        private String logo;

        public CompanyDto(Company company){
                this.name = company.getName();
                this.cnpj = company.getCnpj();
                this.stateReg = company.getStateReg();
                this.adress = company.getAdress();
                this.neighborhood = company.getNeighborhood();
                this.city = company.getCity();
                this.uf = company.getUf();
                this.zipCode = company.getZipCode();
                this.phone = company.getPhone();
                this.cellPhone = company.getCellPhone();;
                this.email = company.getEmail();
                this.logo = company.getLogo();
        }
}