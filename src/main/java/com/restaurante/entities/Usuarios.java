package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private LocalDate dataDeNascimento;
    private String username;
    private String senha;
    private String tipoUsuario;
    private LocalDate criadoEm;
    private LocalDate alteradoEm;
    private LocalDate deletadoEm;

    @OneToMany(mappedBy = "Usuarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Mesas> mesas;

    @OneToMany(mappedBy = "Usuarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Pedido> pedidos;
}
