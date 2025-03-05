package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Optional<SupplierEntity> findSupplierById(Integer id) {
        return supplierRepository.findById(id);
    }
}
