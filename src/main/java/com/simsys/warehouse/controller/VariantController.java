package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.VariantDTO;
import com.simsys.warehouse.service.VariantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variants")
public class VariantController {

    private final VariantService variantService;

    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @Operation(summary = "Create Variant", description = "API to create a new Variant.")
    @PostMapping
    public ResponseEntity<VariantDTO> createVariant(@RequestBody VariantDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(variantService.createVariant(dto));
    }

    @Operation(summary = "Get All Variants", description = "API to retrieve all Variants.")
    @GetMapping
    public ResponseEntity<List<VariantDTO>> getAllVariants() {
        return ResponseEntity.ok(variantService.getAllVariants());
    }

    @Operation(summary = "Get Variant by ID", description = "API to retrieve a Variant by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<VariantDTO> getVariantById(@PathVariable Integer id) {
        return ResponseEntity.ok(variantService.getVariantById(id));
    }

    @Operation(summary = "Update Variant", description = "API to update an existing Variant.")
    @PutMapping("/{id}")
    public ResponseEntity<VariantDTO> updateVariant(@PathVariable Integer id, @RequestBody VariantDTO dto) {
        return ResponseEntity.ok(variantService.updateVariant(id, dto));
    }

    @Operation(summary = "Delete Variant", description = "API to delete a Variant by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVariant(@PathVariable Integer id) {
        variantService.deleteVariant(id);
        return ResponseEntity.ok("Variant has been successfully deleted.");
    }
}
