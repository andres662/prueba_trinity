package com.example.prueba_trinity.Controller;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.InventarioEntity;
import com.example.prueba_trinity.Service.ClienteService;
import com.example.prueba_trinity.Service.InventarioService;
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
@RequestMapping("/tbl_inventario")
public class InventarioController {

    @Autowired
    private InventarioService service;

    @PostMapping
    public ResponseEntity<InventarioEntity> create(@RequestBody InventarioEntity inventario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(inventario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<InventarioEntity> inventario = service.findById(id);
        if (inventario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(inventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioEntity> update(@RequestBody InventarioEntity inventarioDetalis, @PathVariable(value = "id") Long id) {
        Optional<InventarioEntity> inventario = service.findById(id);
        if (inventario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        inventario.get().setNombreProducto(inventarioDetalis.getNombreProducto());
        inventario.get().setNombreCategoria(inventarioDetalis.getNombreCategoria());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(inventario.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventarioEntity> delete(@PathVariable(value = "id") Long inventarioteid) {
        if (service.findById(inventarioteid).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(inventarioteid);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public List<InventarioEntity> readAll(){
        List<InventarioEntity> inventario = StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return inventario;
    }
}
