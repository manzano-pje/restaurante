package com.restaurante.dtos;

import com.restaurante.entities.Clousurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClousurementDto {

    private Integer idClousurement;
    private Integer IdUser;
    private Integer idTable;
    private BigDecimal tableTotal;
    private LocalDateTime dtCreate;

    public ClousurementDto(Clousurement clousurement){
        this.idClousurement = clousurement.getIdClousurement();
        this.IdUser = clousurement.getIdUser();
        this.idTable = clousurement.getIdTable();
        this.tableTotal = clousurement.getTableTotal();
        this.dtCreate = clousurement.getDtCreate();
    }
}
