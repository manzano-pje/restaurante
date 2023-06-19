package com.restaurante.entities;

import com.restaurante.enums.UnitOfMeasurementEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @NonNull
    private Integer idGroup;

    @NonNull
    private Integer idSubGroup;

    @NonNull
    private String name;

    @NonNull
    @Enumerated(EnumType.STRING)
    private UnitOfMeasurementEnum tipoDoProduto;

    @NonNull
    private BigDecimal price;

    @NonNull
    private Integer minimumStock;

    @NonNull Integer stock;




}
