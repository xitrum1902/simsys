package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.ConsignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsignmentRepository extends JpaRepository<ConsignmentEntity, Integer> {
}
