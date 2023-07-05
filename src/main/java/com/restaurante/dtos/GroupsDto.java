package com.restaurante.dtos;

import com.restaurante.entities.Groups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupsDto {

    private String name;

    public GroupsDto(Groups groups){

        this.name = groups.getName();
    }
}
