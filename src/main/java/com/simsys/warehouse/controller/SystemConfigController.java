package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.SystemConfigDTO;
import com.simsys.warehouse.service.SystemConfigService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system-configs")
@Tag(name = "System Configs")
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    @GetMapping
    public List<SystemConfigDTO> getAllSystemConfigs() {
        return systemConfigService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemConfigDTO> getSystemConfigById(@PathVariable Integer id) {
        SystemConfigDTO dto = systemConfigService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SystemConfigDTO> createSystemConfig(@RequestBody SystemConfigDTO dto) {
        return ResponseEntity.ok(systemConfigService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemConfigDTO> updateSystemConfig(@PathVariable Integer id, @RequestBody SystemConfigDTO dto) {
        return ResponseEntity.ok(systemConfigService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSystemConfig(@PathVariable Integer id) {
        systemConfigService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
