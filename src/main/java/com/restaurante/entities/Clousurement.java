package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_closure")
public class Clousurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClousurement;

    private Integer IdUser;
    private Integer idTable;
    private BigDecimal tableTotal;
    private LocalDateTime create;
}
