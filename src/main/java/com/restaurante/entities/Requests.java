package com.restaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_requests")
public class Requests {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequests;

}
