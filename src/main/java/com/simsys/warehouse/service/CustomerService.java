package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.CustomerDTO;
import com.simsys.warehouse.entity.CustomerEntity;
import com.simsys.warehouse.mapper.CustomerMapper;
import com.simsys.warehouse.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO findById(Integer id) {
        return customerRepository.findById(id)
                .map(CustomerMapper::toDTO)
                .orElse(null);
    }

    public CustomerDTO create(CustomerDTO dto) {
        CustomerEntity entity = CustomerMapper.toEntity(dto);
        CustomerEntity savedEntity = customerRepository.save(entity);
        return CustomerMapper.toDTO(savedEntity);
    }

    public CustomerDTO update(Integer id, CustomerDTO dto) {
        CustomerEntity existingEntity = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        existingEntity.setName(dto.getName());
        existingEntity.setAddress(dto.getAddress());
        existingEntity.setPhone(dto.getPhone());
        existingEntity.setEmail(dto.getEmail());
        existingEntity.setStatus(dto.getStatus());
        existingEntity.setBankcard(dto.getBankcard());
        existingEntity.setCreateddate(dto.getCreatedDate());
        existingEntity.setUpdateddate(dto.getUpdatedDate());

        CustomerEntity updatedEntity = customerRepository.save(existingEntity);
        return CustomerMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
