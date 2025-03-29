package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.TransactionDTO;
import com.simsys.warehouse.entity.TransactionEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.entity.OrderEntity;
import com.simsys.warehouse.mapper.TransactionMapper;
import com.simsys.warehouse.repository.TransactionRepository;
import com.simsys.warehouse.repository.UserRepository;
import com.simsys.warehouse.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll().stream()
                .map(TransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransactionDTO findById(Integer id) {
        return transactionRepository.findById(id)
                .map(TransactionMapper::toDTO)
                .orElse(null);
    }

    public TransactionDTO create(TransactionDTO dto) {
        TransactionEntity entity = TransactionMapper.toEntity(dto);

        if (dto.getUserId() != null) {
            UserEntity user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));
            entity.setUserid(user);
        }

        if (dto.getOrderId() != null) {
            OrderEntity order = orderRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Order ID"));
            entity.setOrderid(order);
        }

        TransactionEntity savedEntity = transactionRepository.save(entity);
        return TransactionMapper.toDTO(savedEntity);
    }

    public TransactionDTO update(Integer id, TransactionDTO dto) {
        TransactionEntity existingEntity = transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));

        existingEntity.setMoney(dto.getMoney());
        existingEntity.setNote(dto.getNote());
        existingEntity.setDate(dto.getDate());

        if (dto.getUserId() != null) {
            UserEntity user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));
            existingEntity.setUserid(user);
        }

        if (dto.getOrderId() != null) {
            OrderEntity order = orderRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Order ID"));
            existingEntity.setOrderid(order);
        }

        TransactionEntity updatedEntity = transactionRepository.save(existingEntity);
        return TransactionMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}
