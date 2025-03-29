package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventoryEntity,Integer> {
}
