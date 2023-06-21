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
@Table(name = "tb_tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTables;

    @NonNull
    private String name;

    @NonNull
    private boolean easy;

    /********
     * relacionamentos
     */

    @ManyToOne
    private Users users;


}
