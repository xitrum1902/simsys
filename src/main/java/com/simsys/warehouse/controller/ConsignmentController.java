package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.ConsignmentDTO;
import com.simsys.warehouse.service.ConsignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consignments")
public class ConsignmentController {

    private final ConsignmentService consignmentService;

    public ConsignmentController(ConsignmentService consignmentService) {
        this.consignmentService = consignmentService;
    }

    @PostMapping
    public ResponseEntity<ConsignmentDTO> createConsignment(@RequestBody ConsignmentDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consignmentService.createConsignment(dto));
    }

    @GetMapping
    public ResponseEntity<List<ConsignmentDTO>> getAllConsignments() {
        return ResponseEntity.ok(consignmentService.getAllConsignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsignmentDTO> getConsignmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(consignmentService.getConsignmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsignmentDTO> updateConsignment(@PathVariable Integer id, @RequestBody ConsignmentDTO dto) {
        return ResponseEntity.ok(consignmentService.updateConsignment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsignment(@PathVariable Integer id) {
        consignmentService.deleteConsignment(id);
        return ResponseEntity.ok("Consignment has been successfully deleted.");
    }
}
