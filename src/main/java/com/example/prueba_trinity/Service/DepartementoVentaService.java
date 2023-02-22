package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.DepartementoVentaEntity;
import com.example.prueba_trinity.Entity.InventarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartementoVentaService {
    Iterable<DepartementoVentaEntity> findAll();

    Page<DepartementoVentaEntity> findAll(Pageable pageable);

    Optional<DepartementoVentaEntity> findById(Long id);

    DepartementoVentaEntity save(DepartementoVentaEntity departementoVentaEntity);

    void deleteById(Long id);
}
