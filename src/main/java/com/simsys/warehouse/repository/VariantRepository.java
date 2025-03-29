package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.VariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<VariantEntity,Integer> {
}
