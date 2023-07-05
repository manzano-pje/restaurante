package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_clousurement")
public class Clousurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClousurement;

    private Integer idUser;

    @Column(insertable=false, updatable=false)
    private Integer idTable;
    private BigDecimal tableTotal;
    private LocalDateTime dtCreate;

    /********
     * Relations
     */

    @ManyToOne
    @JoinColumn(name = "idUser", insertable=false, updatable=false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "idTable", insertable=false, updatable=false )
    private Tables tables;

    @OneToMany(mappedBy = "clousurement")
    private List<Payments> payments;
}
