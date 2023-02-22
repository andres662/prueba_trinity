package com.example.prueba_trinity.Repository;

import com.example.prueba_trinity.Entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Long> {
}
