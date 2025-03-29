package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.PurchaseOrderDetailDTO;
import com.simsys.warehouse.service.PurchaseOrderDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-order-details")
@Tag(name = "Purchase Order Details")
public class PurchaseOrderDetailController {

    private final PurchaseOrderDetailService purchaseOrderDetailService;

    public PurchaseOrderDetailController(PurchaseOrderDetailService purchaseOrderDetailService) {
        this.purchaseOrderDetailService = purchaseOrderDetailService;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderDetailDTO> createPurchaseOrderDetail(@RequestBody PurchaseOrderDetailDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseOrderDetailService.createPurchaseOrderDetail(dto));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderDetailDTO>> getAllPurchaseOrderDetails() {
        return ResponseEntity.ok(purchaseOrderDetailService.getAllPurchaseOrderDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderDetailDTO> getPurchaseOrderDetailById(@PathVariable Integer id) {
        return ResponseEntity.ok(purchaseOrderDetailService.getPurchaseOrderDetailById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderDetailDTO> updatePurchaseOrderDetail(@PathVariable Integer id, @RequestBody PurchaseOrderDetailDTO dto) {
        return ResponseEntity.ok(purchaseOrderDetailService.updatePurchaseOrderDetail(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePurchaseOrderDetail(@PathVariable Integer id) {
        purchaseOrderDetailService.deletePurchaseOrderDetail(id);
        return ResponseEntity.ok("PurchaseOrderDetail has been successfully deleted.");
    }
}
