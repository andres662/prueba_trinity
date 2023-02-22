package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.ClientesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClienteService {

    Iterable<ClientesEntity> findAll();

    Page<ClientesEntity> findAll(Pageable pageable);

    Optional<ClientesEntity> findById(Long id);

    ClientesEntity save(ClientesEntity clientesEntity);

    void deleteById(Long id);
}
