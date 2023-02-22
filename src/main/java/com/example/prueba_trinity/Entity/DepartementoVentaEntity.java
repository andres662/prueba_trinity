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
@Table(name = "tbl_departamentoVenta")
public class DepartementoVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombreVendedor", length = 50, nullable = false, unique = true)
    private String nombreVendedor;

    @Column(name = "nombreCategoria", length = 50, nullable = false)
    private String nombreCategoria;
}
