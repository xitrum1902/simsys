package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.TransferRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRequestRepository extends JpaRepository<TransferRequestEntity, Integer> {
}
