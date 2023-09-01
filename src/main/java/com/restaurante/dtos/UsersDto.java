package com.restaurante.dtos;

import com.restaurante.entities.Users;
import java.time.LocalDate;

public class UsersDto {

    private Integer idUser;
    private String name;
    private String email;
    private String phone;
    private String adress;
    private String neighborhood;
    private String city;
    private String uf;
    private LocalDate dateOfBirth;
    private String username;
    private String password;

    public UsersDto(Users users){
        this.name = users.getName();
        this.email = users.getEmail();
        this.phone = users.getPhone();
        this.adress = users.getAdress();
        this.neighborhood = users.getNeighborhood();
        this.city = users.getCity();
        this.uf = users.getUf();
        this.dateOfBirth = users.getDateOfBirth();
        this.username = users.getUsername();
        this.password = users.getPassword();
    }
}
