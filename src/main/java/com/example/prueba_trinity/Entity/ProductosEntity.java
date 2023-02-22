package com.example.prueba_trinity.Entity;


import com.example.prueba_trinity.Repository.ProductoRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_productos")
public class ProductosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombreProducto", length = 50, nullable = false, unique = true)
    private String nombreProducto;

    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;

    @Column(name = "precio", length = 50, nullable = false)
    private String precio;

    @Column(name = "cantidad", length = 50, nullable = false)
    private String cantidad;

    @Column(name = "total", length = 50, nullable = false)
    private String total;

    @ManyToOne
    @Setter @Getter
    private ClientesEntity clientes;

}
