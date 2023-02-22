package com.example.prueba_trinity.Controller;

import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.DepartementoVentaEntity;
import com.example.prueba_trinity.Service.DepartementoVentaService;
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
@RequestMapping("/tbl_departamentoVenta")
public class DepartamentoVentaController {

    @Autowired
    private DepartementoVentaService service;

    @PostMapping
    public ResponseEntity<DepartementoVentaEntity> create(@RequestBody DepartementoVentaEntity departementoVenta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departementoVenta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<DepartementoVentaEntity> departementoVenta = service.findById(id);
        if (departementoVenta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departementoVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartementoVentaEntity> update(@RequestBody DepartementoVentaEntity departementoVentaDatails, @PathVariable(value = "id") Long id) {
        Optional<DepartementoVentaEntity> departementoVenta = service.findById(id);
        if (departementoVenta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        departementoVenta.get().setNombreVendedor(departementoVentaDatails.getNombreVendedor());
        departementoVenta.get().setNombreCategoria(departementoVentaDatails.getNombreCategoria());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departementoVenta.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartementoVentaEntity> delete(@PathVariable(value = "id") Long departementoventateid) {
        if (service.findById(departementoventateid).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(departementoventateid);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public List<DepartementoVentaEntity> readAll(){
        List<DepartementoVentaEntity> departementoVentaEntities = StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return departementoVentaEntities;
    }
}
