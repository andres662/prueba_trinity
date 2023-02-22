package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.PlanSepareEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PlanSepareService {

    Iterable<PlanSepareEntity> findAll();

    Page<PlanSepareEntity> findAll(Pageable pageable);

    Optional<PlanSepareEntity> findById(Long id);

    PlanSepareEntity save(PlanSepareEntity planSepareEntity);

    void deleteById(Long id);
}
