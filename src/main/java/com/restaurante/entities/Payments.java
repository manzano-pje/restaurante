package com.restaurante.entities;

import com.restaurante.enums.PaymentMethods;
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
@Table(name = "tb_payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPayment;

    @Column(insertable=false, updatable=false)
    private Integer idClousement;

    private PaymentMethods PaymentMethod;
    private BigDecimal price;
    private LocalDateTime dtCreate;

    /********
     * Relations
     */

    @ManyToOne
    @JoinColumn(name = "idClousurement")
    private Clousurement clousurement;
}
