package com.example.prueba_trinity.Service;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.ProductosEntity;
import com.example.prueba_trinity.Repository.ClientesRepository;
import com.example.prueba_trinity.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
@Service
public class ProductosServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository repository;
    private ProductosEntity productos;
    ClientesEntity clientesEntity;

    @Autowired
    ClientesRepository clientesRepository;

    @Override
    public Iterable<ProductosEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<ProductosEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<ProductosEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ClientesEntity> readId(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    public ProductosEntity save(ProductosEntity productosEntity) {

        ClientesEntity clientes = this.clientesRepository.findByIdCliente(productosEntity.getClientes().getId());
        productosEntity.setClientes(clientes);

        return repository.save(productosEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }




}
