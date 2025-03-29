package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.OrderDetailDTO;
import com.simsys.warehouse.entity.OrderDetailEntity;
import com.simsys.warehouse.entity.UserInventoryEntity;
import com.simsys.warehouse.entity.OrderEntity;
import com.simsys.warehouse.mapper.OrderDetailMapper;
import com.simsys.warehouse.repository.OrderDetailRepository;
import com.simsys.warehouse.repository.UserInventoryRepository;
import com.simsys.warehouse.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private UserInventoryRepository userInventoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDetailDTO> findAll() {
        return orderDetailRepository.findAll().stream()
                .map(OrderDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDetailDTO findById(Integer id) {
        return orderDetailRepository.findById(id)
                .map(OrderDetailMapper::toDTO)
                .orElse(null);
    }

    public OrderDetailDTO create(OrderDetailDTO dto) {
        OrderDetailEntity entity = OrderDetailMapper.toEntity(dto);

        if (dto.getUserInventoryId() != null) {
            UserInventoryEntity userInventory = userInventoryRepository.findById(dto.getUserInventoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid UserInventory ID"));
            entity.setUserinventoryid(userInventory);
        }

        if (dto.getOrderId() != null) {
            OrderEntity order = orderRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Order ID"));
            entity.setOrderid(order);
        }

        OrderDetailEntity savedEntity = orderDetailRepository.save(entity);
        return OrderDetailMapper.toDTO(savedEntity);
    }

    public OrderDetailDTO update(Integer id, OrderDetailDTO dto) {
        OrderDetailEntity existingEntity = orderDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderDetail not found"));

        existingEntity.setQuantity(dto.getQuantity());
        existingEntity.setSaleprice(dto.getSalePrice());

        if (dto.getUserInventoryId() != null) {
            UserInventoryEntity userInventory = userInventoryRepository.findById(dto.getUserInventoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid UserInventory ID"));
            existingEntity.setUserinventoryid(userInventory);
        }

        if (dto.getOrderId() != null) {
            OrderEntity order = orderRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Order ID"));
            existingEntity.setOrderid(order);
        }

        OrderDetailEntity updatedEntity = orderDetailRepository.save(existingEntity);
        return OrderDetailMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        orderDetailRepository.deleteById(id);
    }
}
