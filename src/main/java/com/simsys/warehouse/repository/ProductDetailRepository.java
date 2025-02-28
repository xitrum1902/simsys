package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.projection.ProductDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Integer> {

    @Query("""
        SELECT pd.productDetailID AS productDetailID, 
               pd.totalQuantity AS totalQuantity,
               v.name AS variantName,
               vv.value AS variantValue
        FROM ProductDetailEntity pd
        JOIN pd.variantValues pdvv
        JOIN pdvv.variantValue vv
        JOIN vv.variant v
        WHERE pd.totalQuantity < :quantityLimit
        ORDER BY pd.productDetailID
    """)
    List<ProductDetailProjection> findProductDetailsWithVariants(@Param("quantityLimit") int quantityLimit);
}
