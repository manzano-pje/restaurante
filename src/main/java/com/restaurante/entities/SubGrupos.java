package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "subgrupos")
public class SubGrupo  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubGrupo;
    private String nome;



    /// um sub-grupo para um produto
    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "idProduto")
    private Produtos produtos;
}
