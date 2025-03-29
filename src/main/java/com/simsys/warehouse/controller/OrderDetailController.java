package com.simsys.warehouse.controller;

import com.simsys.warehouse.dto.OrderDetailDTO;
import com.simsys.warehouse.service.OrderDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@Tag(name = "OrderDetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public List<OrderDetailDTO> getAllOrderDetails() {
        return orderDetailService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> getOrderDetailById(@PathVariable Integer id) {
        OrderDetailDTO dto = orderDetailService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrderDetailDTO> createOrderDetail(@RequestBody OrderDetailDTO dto) {
        return ResponseEntity.ok(orderDetailService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> updateOrderDetail(@PathVariable Integer id, @RequestBody OrderDetailDTO dto) {
        return ResponseEntity.ok(orderDetailService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Integer id) {
        orderDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
