package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.RequestPurchaseOrderDTO;
import com.simsys.warehouse.service.RequestPurchaseOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request-purchase-order")
@Tag(name = "Request Purchase Order")
public class RequestPurchaseOrderController {
    private final RequestPurchaseOrderService requestPurchaseOrderService;

    public RequestPurchaseOrderController(RequestPurchaseOrderService requestOrderService) {
        this.requestPurchaseOrderService = requestOrderService;
    }

    @Operation(summary = "Create Request Purchase Order", description = "API Create Request Purchase Order.")
    @ApiResponse(responseCode = "200", description = "Successful",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/create")
    public ResponseEntity<RequestPurchaseOrderDTO> createRequestPurchaseOrder(@RequestBody RequestPurchaseOrderDTO requestDto) {
        RequestPurchaseOrderDTO savedOrders = requestPurchaseOrderService.createRequestOrder(requestDto);
        return ResponseEntity.ok(savedOrders);
    }

    @Operation(summary = "Get Request Purchase Order", description = "API này trả về Request Purchase Order.")
    @ApiResponse(responseCode = "200", description = "Successful",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/get")
    public ResponseEntity<RequestPurchaseOrderDTO> getRequestPurchaseOrder(@RequestParam int id) {
        return requestPurchaseOrderService.getRequestOrder(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get List Request Purchase Order", description = "API này trả về danh sách Request Purchase Order.")
    @ApiResponse(responseCode = "200", description = "Successful",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/get-all")
    public ResponseEntity<List<RequestPurchaseOrderDTO>> getAllRequestPurchaseOrders() {
        List<RequestPurchaseOrderDTO> requestOrders = requestPurchaseOrderService.getAllRequestOrders();
        if (requestOrders.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có dữ liệu
        }
        return ResponseEntity.ok(requestOrders);
    }

    @Operation(summary = "Delete Request Purchase Order", description = "API này trả status code.")
    @ApiResponse(responseCode = "200", description = "Successful",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequestPurchaseOrder(@PathVariable int id) {
        try {
            requestPurchaseOrderService.deleteRequestPurchaseOrder(id);
            return ResponseEntity.ok("Request Purchase Order has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @Operation(summary = "Update Request Purchase Order", description = "API này trả về Request Purchase Order.")
    @ApiResponse(responseCode = "200", description = "Successful",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/{id}")
    public ResponseEntity<RequestPurchaseOrderDTO> updateRequestPurchaseOrder(
            @PathVariable("id") int id,
            @RequestBody RequestPurchaseOrderDTO updatedData) {
        try {
            // Gọi service để cập nhật RequestPurchaseOrder
            RequestPurchaseOrderDTO updatedOrder = requestPurchaseOrderService.updateRequestOrder(id, updatedData);

            // Trả về 200 OK và dữ liệu đã cập nhật
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            // Nếu không tìm thấy hoặc lỗi xảy ra, trả về 404 NOT FOUND hoặc 400 BAD REQUEST
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
