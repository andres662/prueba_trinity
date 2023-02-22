package com.example.prueba_trinity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_clientes")
public class ClientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cedula", length = 50, nullable = false, unique = true)
    private String cedula;

    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "clientes")
    List<ProductosEntity> productosEntities ;
}
