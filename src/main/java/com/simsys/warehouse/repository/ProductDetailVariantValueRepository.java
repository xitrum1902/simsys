package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.ProductDetailVariantValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailVariantValueRepository extends JpaRepository<ProductDetailVariantValueEntity, Integer> {
}
