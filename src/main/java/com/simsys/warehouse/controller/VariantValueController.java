package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.VariantValueDTO;
import com.simsys.warehouse.service.VariantValueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variant-values")
public class VariantValueController {

    private final VariantValueService variantValueService;

    public VariantValueController(VariantValueService variantValueService) {
        this.variantValueService = variantValueService;
    }

    @Operation(summary = "Create Variant Value", description = "API to create a new Variant Value.")
    @PostMapping
    public ResponseEntity<VariantValueDTO> createVariantValue(@RequestBody VariantValueDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(variantValueService.createVariantValue(dto));
    }

    @Operation(summary = "Get All Variant Values", description = "API to retrieve all Variant Values.")
    @GetMapping
    public ResponseEntity<List<VariantValueDTO>> getAllVariantValues() {
        return ResponseEntity.ok(variantValueService.getAllVariantValues());
    }

    @Operation(summary = "Get Variant Value by ID", description = "API to retrieve a Variant Value by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<VariantValueDTO> getVariantValueById(@PathVariable Integer id) {
        return ResponseEntity.ok(variantValueService.getVariantValueById(id));
    }

    @Operation(summary = "Update Variant Value", description = "API to update an existing Variant Value.")
    @PutMapping("/{id}")
    public ResponseEntity<VariantValueDTO> updateVariantValue(@PathVariable Integer id, @RequestBody VariantValueDTO dto) {
        return ResponseEntity.ok(variantValueService.updateVariantValue(id, dto));
    }

    @Operation(summary = "Delete Variant Value", description = "API to delete a Variant Value by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVariantValue(@PathVariable Integer id) {
        variantValueService.deleteVariantValue(id);
        return ResponseEntity.ok("Variant Value has been successfully deleted.");
    }
}
