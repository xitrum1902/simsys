package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.ProductDetailVariantValueDTO;
import com.simsys.warehouse.service.ProductDetailVariantValueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-detail-variant-values")
@Tag(name = "Product Detail Variant Values")
public class ProductDetailVariantValueController {

    @Autowired
    private ProductDetailVariantValueService productDetailVariantValueService;

    @GetMapping
    public List<ProductDetailVariantValueDTO> getAll() {
        return productDetailVariantValueService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailVariantValueDTO> getById(@PathVariable Integer id) {
        ProductDetailVariantValueDTO dto = productDetailVariantValueService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductDetailVariantValueDTO> create(@RequestBody ProductDetailVariantValueDTO dto) {
        return ResponseEntity.ok(productDetailVariantValueService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailVariantValueDTO> update(@PathVariable Integer id, @RequestBody ProductDetailVariantValueDTO dto) {
        return ResponseEntity.ok(productDetailVariantValueService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productDetailVariantValueService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
