package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.TransferRequestDTO;
import com.simsys.warehouse.service.TransferRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer-requests")
@Tag(name = "Transfer Requests")
public class TransferRequestController {

    @Autowired
    private TransferRequestService transferRequestService;

    @GetMapping
    public List<TransferRequestDTO> getAllTransferRequests() {
        return transferRequestService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferRequestDTO> getTransferRequestById(@PathVariable Integer id) {
        TransferRequestDTO dto = transferRequestService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransferRequestDTO> createTransferRequest(@RequestBody TransferRequestDTO dto) {
        return ResponseEntity.ok(transferRequestService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferRequestDTO> updateTransferRequest(@PathVariable Integer id, @RequestBody TransferRequestDTO dto) {
        return ResponseEntity.ok(transferRequestService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransferRequest(@PathVariable Integer id) {
        transferRequestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
