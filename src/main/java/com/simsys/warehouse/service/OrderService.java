package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.OrderDTO;
import com.simsys.warehouse.entity.CustomerEntity;
import com.simsys.warehouse.entity.OrderEntity;
import com.simsys.warehouse.mapper.OrderMapper;
import com.simsys.warehouse.repository.CustomerRepository;
import com.simsys.warehouse.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findById(Integer id) {
        return orderRepository.findById(id)
                .map(OrderMapper::toDTO)
                .orElse(null);
    }

    public OrderDTO create(OrderDTO dto) {
        CustomerEntity customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        OrderEntity entity = OrderMapper.toEntity(dto, customer);
        OrderEntity savedEntity = orderRepository.save(entity);
        return OrderMapper.toDTO(savedEntity);
    }

    public OrderDTO update(Integer id, OrderDTO dto) {
        OrderEntity existingEntity = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        CustomerEntity customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        existingEntity.setTotalprice(dto.getTotalPrice());
        existingEntity.setOrderdate(dto.getOrderDate());
        existingEntity.setStatus(dto.getStatus());
        existingEntity.setCustomerid(customer);

        OrderEntity updatedEntity = orderRepository.save(existingEntity);
        return OrderMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
