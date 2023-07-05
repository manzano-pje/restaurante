package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGroup;

    @NonNull
    private String name;

    /********
     * Relatons
     */

    @OneToMany(mappedBy = "groups")
    private List<SubGroups> subGroups;
}
