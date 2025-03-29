package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.ProductInventoryDTO;
import com.simsys.warehouse.service.ProductInventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-inventories")
@Tag(name = "Product Inventories")
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;

    @GetMapping
    public List<ProductInventoryDTO> getAllProductInventories() {
        return productInventoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInventoryDTO> getProductInventoryById(@PathVariable Integer id) {
        ProductInventoryDTO dto = productInventoryService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductInventoryDTO> createProductInventory(@RequestBody ProductInventoryDTO dto) {
        return ResponseEntity.ok(productInventoryService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductInventoryDTO> updateProductInventory(@PathVariable Integer id, @RequestBody ProductInventoryDTO dto) {
        return ResponseEntity.ok(productInventoryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductInventory(@PathVariable Integer id) {
        productInventoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
