package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompany;

    @NonNull
    private String cnpj;

    @NonNull
    private String stateReg;

    @NonNull
    private String name;

    @NonNull
    private String adress;

    @NonNull
    private String neighborhood;

    @NonNull
    private String city;

    @NonNull
    private String uf;

    @NonNull
    private String zipCode;

    @NonNull
    private String phone;

    private String cellPhone;

    @NonNull
    private String email;

    @NonNull
    private String logo;

}
