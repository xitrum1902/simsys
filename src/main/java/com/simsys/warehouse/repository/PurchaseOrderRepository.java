package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.PurchaseOrderEntity;
import com.simsys.warehouse.service.PurchaseOrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderEntity, Integer> {
}
