package com.restaurante.dtos;

import com.restaurante.entities.SubGroups;

public class SubGroupDto {

    private Integer idSubGroup;
    private String name;
    private Integer idGroup;

    public SubGroupDto(SubGroups subGroups){
        this.name = subGroups.getName();
        this.idGroup = subGroups.getIdGroup();
    }
}
