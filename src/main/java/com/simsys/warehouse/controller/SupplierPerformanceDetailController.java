package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.SupplierPerformanceDetailDTO;
import com.simsys.warehouse.service.SupplierPerformanceDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-performance-details")
@Tag(name = "Supplier Performance Details")
public class SupplierPerformanceDetailController {

    @Autowired
    private SupplierPerformanceDetailService supplierPerformanceDetailService;

    @GetMapping
    public List<SupplierPerformanceDetailDTO> getAll() {
        return supplierPerformanceDetailService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierPerformanceDetailDTO> getById(@PathVariable Integer id) {
        SupplierPerformanceDetailDTO dto = supplierPerformanceDetailService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SupplierPerformanceDetailDTO> create(@RequestBody SupplierPerformanceDetailDTO dto) {
        return ResponseEntity.ok(supplierPerformanceDetailService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierPerformanceDetailDTO> update(@PathVariable Integer id, @RequestBody SupplierPerformanceDetailDTO dto) {
        return ResponseEntity.ok(supplierPerformanceDetailService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        supplierPerformanceDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
