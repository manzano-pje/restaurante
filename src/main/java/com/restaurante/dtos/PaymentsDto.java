package com.restaurante.dtos;

import com.restaurante.entities.Payments;
import com.restaurante.enums.PaymentMethods;

import java.math.BigDecimal;

public class PaymentsDto {
    private Integer idPayment;
    private Integer idClousement;
    private PaymentMethods PaymentMethod;
    private BigDecimal price;
    private java.time.LocalDateTime dtCreate;

    public PaymentsDto(Payments payments){
        this.idPayment = payments.getIdPayment();;
        this.idClousement = payments.getIdClousement();
        this.PaymentMethod = payments.getPaymentMethod();
        this.price = payments.getPrice();
        this.dtCreate = payments.getDtCreate();
    }
}
