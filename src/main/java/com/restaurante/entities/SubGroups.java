package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_subGroups")
public class SubGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubGroup;

    private String name;

    private Integer idGroup;
}
