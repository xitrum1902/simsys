package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.VariantValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantValueRepository extends JpaRepository<VariantValueEntity,Integer> {
}
