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
    @JoinColumn(name = "idTables", insertable=false, updatable=false)
    private Users users;

    @OneToMany(mappedBy = "tables")
    private List<Clousurement> clousurements;

    @OneToMany(mappedBy = "tables")
    private List<Requests> requests;

}
