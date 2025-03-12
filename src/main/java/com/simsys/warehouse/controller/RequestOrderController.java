package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.RequestOrderDTO;
import com.simsys.warehouse.service.RequestOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request-order")
public class RequestOrderController {
    private final RequestOrderService requestOrderService;

    public RequestOrderController(RequestOrderService requestOrderService) {
        this.requestOrderService = requestOrderService;
    }
    @PostMapping("/create")
    public ResponseEntity<List<RequestOrderDTO>> createRequestOrder(@RequestParam int lowerBound) {
        List<RequestOrderDTO> savedOrders = requestOrderService.createRequestOrdersFromVariants(20,1, 2, 100);
        if (savedOrders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrders);
    }

    @PostMapping("/create-request-order")
    public ResponseEntity<List<RequestOrderDTO>> createRequestOrder(@RequestBody RequestOrderDTO requestDto) {
        List<RequestOrderDTO> savedOrders = requestOrderService.createRequestOrder(requestDto);
        return ResponseEntity.ok(savedOrders);
    }

}
