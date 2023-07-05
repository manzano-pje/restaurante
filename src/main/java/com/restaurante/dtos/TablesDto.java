package com.restaurante.dtos;

import com.restaurante.entities.Tables;
public class TablesDto {

    private Integer idTables;
    private String name;
    private boolean easy;

    public boolean isEasy() {
        return easy;
    }

    public void setEasy(boolean easy) {
        this.easy = easy;
    }

    public TablesDto(Tables tables){
        this.name = tables.getName();
    }
}
