package com.example.prueba_trinity.Repository;

import com.example.prueba_trinity.Entity.DepartementoVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoVentaRepository extends JpaRepository<DepartementoVentaEntity, Long> {
}
