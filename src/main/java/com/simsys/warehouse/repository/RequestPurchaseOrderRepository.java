package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.RequestPurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestPurchaseOrderRepository extends JpaRepository<RequestPurchaseOrderEntity, Integer> {

}
