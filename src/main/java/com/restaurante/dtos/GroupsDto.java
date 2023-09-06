package com.restaurante.dtos;

import com.restaurante.entities.Groups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupsDto {

    private long idGroup;
    private String name;

    public GroupsDto(Groups groups){
        this.idGroup = groups.getIdGroup();
        this.name = groups.getName();
    }

}
