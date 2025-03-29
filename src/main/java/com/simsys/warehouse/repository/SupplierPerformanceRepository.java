package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.SupplierPerformanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierPerformanceRepository extends JpaRepository<SupplierPerformanceEntity, Integer> {

}
