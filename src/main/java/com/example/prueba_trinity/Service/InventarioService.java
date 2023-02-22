package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.InventarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InventarioService {
    Iterable<InventarioEntity> findAll();

    Page<InventarioEntity> findAll(Pageable pageable);

    Optional<InventarioEntity> findById(Long id);

    InventarioEntity save(InventarioEntity inventarioEntity);

    void deleteById(Long id);
}
