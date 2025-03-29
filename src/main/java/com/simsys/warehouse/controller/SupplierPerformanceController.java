package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.SupplierPerformanceDTO;
import com.simsys.warehouse.service.SupplierPerformanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-performances")
@Tag(name = "Supplier Performances")
public class SupplierPerformanceController {

    @Autowired
    private SupplierPerformanceService service;

    @GetMapping
    public List<SupplierPerformanceDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierPerformanceDTO> getById(@PathVariable Integer id) {
        SupplierPerformanceDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SupplierPerformanceDTO> create(@RequestBody SupplierPerformanceDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierPerformanceDTO> update(@PathVariable Integer id, @RequestBody SupplierPerformanceDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
