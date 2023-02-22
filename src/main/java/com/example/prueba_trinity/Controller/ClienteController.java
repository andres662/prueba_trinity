package com.example.prueba_trinity.Controller;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.ProductosEntity;
import com.example.prueba_trinity.Repository.ProductoRepository;
import com.example.prueba_trinity.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/tbl_clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClientesEntity> create(@RequestBody ClientesEntity clientes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<ClientesEntity> clientes = service.findById(id);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesEntity> update(@RequestBody ClientesEntity clientesDetalis, @PathVariable(value = "id") Long id) {
        Optional<ClientesEntity> clientes = service.findById(id);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        clientes.get().setCedula(clientesDetalis.getCedula());
        clientes.get().setDireccion(clientesDetalis.getDireccion());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientes.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientesEntity> delete(@PathVariable(value = "id") Long clienteid) {
        if (service.findById(clienteid).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(clienteid);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public List<ClientesEntity> readAll(){
        List<ClientesEntity> cliente = StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return cliente;
    }




}
