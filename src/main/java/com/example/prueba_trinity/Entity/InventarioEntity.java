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
@Table(name = "tbl_inventario")
public class InventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombreProducto", length = 50, nullable = false, unique = true)
    private String nombreProducto;

    @Column(name = "nombreCategoria", length = 50, nullable = false)
    private String nombreCategoria;
}
