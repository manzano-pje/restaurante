package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

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

    /********
     * Relations
     */

    @OneToMany(mappedBy = "subGroups")
    private List<Products> products;

    @ManyToOne
    @JoinColumn(name = "idGroup", insertable=false, updatable=false)
    private Groups groups;

}
