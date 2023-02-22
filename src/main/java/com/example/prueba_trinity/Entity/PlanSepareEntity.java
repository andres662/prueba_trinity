package com.example.prueba_trinity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_planSepare")
public class PlanSepareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productosSeparados", length = 50, nullable = false, unique = true)
    private String productosSeparados;

    @Column(name = "cantidadCompras", length = 50, nullable = false)
    private String cantidadCompras;
}
