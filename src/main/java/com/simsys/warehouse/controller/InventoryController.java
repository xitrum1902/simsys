package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.InventoryDTO;
import com.simsys.warehouse.service.InventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
@Tag(name = "Inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryDTO> getAllInventories() {
        return inventoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable Integer id) {
        InventoryDTO inventoryDTO = inventoryService.findById(id);
        return inventoryDTO != null ? ResponseEntity.ok(inventoryDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO) {
        return ResponseEntity.ok(inventoryService.create(inventoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Integer id, @RequestBody InventoryDTO inventoryDTO) {
        return ResponseEntity.ok(inventoryService.update(id, inventoryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Integer id) {
        inventoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
