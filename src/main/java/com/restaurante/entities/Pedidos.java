package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private Long idUsuario;
    private Long idMesa;
    private Long idProduto;
    private Integer quantidade;
    private BigDecimal valorTotalProduto;
    private BigDecimal totalPedido;


    /// varios pedidos para um usuario
    @ManyToOne
    private Usuario usuarios;

    /// varios pedidos para varios produtos
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "pedido_produto",
    joinColumns = {@JoinColumn(name = "idPedido")},
    inverseJoinColumns = {@JoinColumn(name = "idProduto")})
    private List<Produtos> produtos;

    /// um pedido para uma mesa
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idMesa")
    private Mesas mesa;
}
