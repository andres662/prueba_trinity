package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.InventarioEntity;
import com.example.prueba_trinity.Repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService{

    @Autowired
    private InventarioRepository repository;

    @Override
    public Iterable<InventarioEntity> findAll() { return repository.findAll(); }

    @Override
    public Page<InventarioEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<InventarioEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public InventarioEntity save(InventarioEntity inventarioEntity) {
        return repository.save(inventarioEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
