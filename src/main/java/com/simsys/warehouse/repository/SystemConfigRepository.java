package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.SystemConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemConfigRepository extends JpaRepository<SystemConfigEntity, Integer> {
}
