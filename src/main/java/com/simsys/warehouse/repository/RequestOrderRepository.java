package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.RequestOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestOrderRepository extends JpaRepository<RequestOrderEntity, Integer> {
}
