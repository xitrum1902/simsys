package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.UserInventoryDTO;
import com.simsys.warehouse.service.UserInventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-inventory")
@Tag(name = "User Inventory")
public class UserInventoryController {

    @Autowired
    private UserInventoryService userInventoryService;

    @GetMapping
    public List<UserInventoryDTO> getAllUserInventories() {
        return userInventoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInventoryDTO> getUserInventoryById(@PathVariable Integer id) {
        UserInventoryDTO dto = userInventoryService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserInventoryDTO> createUserInventory(@RequestBody UserInventoryDTO dto) {
        return ResponseEntity.ok(userInventoryService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInventoryDTO> updateUserInventory(@PathVariable Integer id, @RequestBody UserInventoryDTO dto) {
        return ResponseEntity.ok(userInventoryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserInventory(@PathVariable Integer id) {
        userInventoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
