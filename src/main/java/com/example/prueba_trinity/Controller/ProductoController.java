package com.example.prueba_trinity.Controller;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.ProductosEntity;
import com.example.prueba_trinity.Repository.ClientesRepository;
import com.example.prueba_trinity.Service.ClienteService;
import com.example.prueba_trinity.Service.ProductoService;
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
@RequestMapping("/tbl_productos")
public class ProductoController {

    @Autowired
    private ProductoService service;
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ProductosEntity> create(@RequestBody ProductosEntity productos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<ProductosEntity> productos = service.findById(id);
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosEntity> update(@RequestBody ProductosEntity productosDetalis, @PathVariable(value = "id") Long id) {
        Optional<ProductosEntity> productos = service.findById(id);
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        productos.get().setNombreProducto(productosDetalis.getNombreProducto());
        productos.get().setDescripcion(productos.get().getDescripcion());
        productos.get().setPrecio(productosDetalis.getPrecio());
        productos.get().setCantidad(productos.get().getCantidad());
        productos.get().setTotal(productos.get().getTotal());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productos.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductosEntity> delete(@PathVariable(value = "id") Long productosid) {
        if (service.findById(productosid).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(productosid);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public List<ProductosEntity> readAll(){
        List<ProductosEntity> productosEntities = StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return productosEntities;
    }


}
