package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.ProductosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductoService {



    Iterable<ProductosEntity> findAll();

    Page<ProductosEntity> findAll(Pageable pageable);

    Optional<ProductosEntity> findById(Long id);

    Optional<?> readId(Long id);

    ProductosEntity save(ProductosEntity productosEntity);

    void deleteById(Long id);
}
