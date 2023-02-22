package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.PlanSepareEntity;
import com.example.prueba_trinity.Repository.PlanSepareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanSepareServiceImpl implements PlanSepareService{

    @Autowired
    private PlanSepareRepository repository;

    @Override
    public Iterable<PlanSepareEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<PlanSepareEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<PlanSepareEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PlanSepareEntity save(PlanSepareEntity planSepareEntity) {
        return repository.save(planSepareEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
