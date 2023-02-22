package com.example.prueba_trinity.Repository;

import com.example.prueba_trinity.Entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductosEntity, Long> {
}
