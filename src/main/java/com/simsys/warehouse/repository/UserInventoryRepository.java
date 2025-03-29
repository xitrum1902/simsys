package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.UserInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInventoryRepository extends JpaRepository<UserInventoryEntity, Integer> {
}
