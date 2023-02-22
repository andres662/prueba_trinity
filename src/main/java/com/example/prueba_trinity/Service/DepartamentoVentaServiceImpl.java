package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.DepartementoVentaEntity;
import com.example.prueba_trinity.Repository.DepartamentoVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartamentoVentaServiceImpl implements DepartementoVentaService{
    @Autowired
    private DepartamentoVentaRepository repository;

    @Override
    public Iterable<DepartementoVentaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<DepartementoVentaEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<DepartementoVentaEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public DepartementoVentaEntity save(DepartementoVentaEntity departementoVentaEntity) {
        return repository.save(departementoVentaEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
