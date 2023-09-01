package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tb_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

}
