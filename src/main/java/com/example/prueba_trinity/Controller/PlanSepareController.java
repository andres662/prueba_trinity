package com.example.prueba_trinity.Controller;


import com.example.prueba_trinity.Entity.ClientesEntity;
import com.example.prueba_trinity.Entity.PlanSepareEntity;
import com.example.prueba_trinity.Service.PlanSepareService;
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
@RequestMapping("/tbl_planSepare")
public class PlanSepareController {

    @Autowired
    private PlanSepareService service;

    @PostMapping
    public ResponseEntity<PlanSepareEntity> create(@RequestBody PlanSepareEntity planSepareEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(planSepareEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<PlanSepareEntity> planSepareEntity = service.findById(id);
        if (planSepareEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(planSepareEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanSepareEntity> update(@RequestBody PlanSepareEntity planSepareDetalis, @PathVariable(value = "id") Long id) {
        Optional<PlanSepareEntity> planSepare = service.findById(id);
        if (planSepare.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        planSepare.get().setProductosSeparados(planSepareDetalis.getProductosSeparados());
        planSepare.get().setCantidadCompras(planSepareDetalis.getCantidadCompras());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(planSepare.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlanSepareEntity> delete(@PathVariable(value = "id") Long plansepareid) {
        if (service.findById(plansepareid).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(plansepareid);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public List<PlanSepareEntity> readAll(){
        List<PlanSepareEntity> planSepareEntities = StreamSupport.stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return planSepareEntities;
    }

}
