package com.restaurante.dtos;

import com.restaurante.entities.Clousurement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ClousurementDto {

    private Integer idClousurement;
    private Integer IdUser;
    private Integer idTable;
    private BigDecimal tableTotal;
    private LocalDateTime create;

    public ClousurementDto(Clousurement clousurement){
        this.idClousurement = clousurement.getIdClousurement();
        this.IdUser = clousurement.getIdUser();
        this.idTable = clousurement.getIdTable();
        this.tableTotal = clousurement.getTableTotal();
        this.create = clousurement.getCreate();
    }
}
