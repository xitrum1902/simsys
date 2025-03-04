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

//    @Query(value = """
//    select
//        pd.productdetailid as productDetailId,
//        pd.totalquantity as totalQuantity,
//        p.name as productName,
//        string_agg(distinct vv.value, ', ')
//            filter (where v.name = 'color') as colorValues,
//        string_agg(distinct vv.value, ', ')
//            filter (where v.name = 'size') as sizeValues
//    from public.productdetail pd
//    join public.product p
//        on pd.productid = p.productid
//    join public.productdetailvariantvalue pdvv
//        on pd.productdetailid = pdvv.productdetailid
//    join public.variantvalue vv
//        on pdvv.variantvalueid = vv.variantvalueid
//    join public.variant v
//        on vv.variantid = v.variantid
//    where pd.totalquantity < :quantityLimit
//    group by pd.productdetailid, pd.totalquantity, p.name
//    """, nativeQuery = true)
    @Query(value = """
    select 
    pd.productdetailid as productDetailId,
    pd.totalquantity as totalQuantity,
    p.name as productName,
    string_agg(vv.value, ', ') filter (where v.name = 'color') as colorValues,
    string_agg(vv.value, ', ') filter (where v.name = 'size') as sizeValues
from public.productdetail pd
join public.product p 
    on pd.productid = p.productid
left join public.productdetailvariantvalue pdvv 
    on pd.productdetailid = pdvv.productdetailid
left join public.variantvalue vv 
    on pdvv.variantvalueid = vv.variantvalueid
left join public.variant v 
    on vv.variantid = v.variantid
where pd.totalquantity < :quantityLimit
group by pd.productdetailid, pd.totalquantity, p.name;
""", nativeQuery = true)
    List<ProductDetailProjection> findProductDetailsWithVariants(@Param("quantityLimit") int quantityLimit);

}
