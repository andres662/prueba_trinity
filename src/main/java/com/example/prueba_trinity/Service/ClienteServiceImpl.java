package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.ProductosEntity;
import com.example.prueba_trinity.Repository.ClientesRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;;

@Service
public class ClienteServiceImpl implements ClienteService
{

    @Autowired
    private ClientesRepository repository;
    

    @Override
    public Iterable<ClientesEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<ClientesEntity> findAll(Pageable pageable) {


        return repository.findAll(pageable);
    }

    @Override
    public Optional<ClientesEntity> findById(Long id) {


        return repository.findById(id);
    }

    @Override
    public ClientesEntity save(ClientesEntity clientesEntity) {

        return repository.save(clientesEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }




    @ManyToOne
    private ClientesEntity clientes;

    }




