package com.simsys.warehouse.service;

import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductDetailService {
    @Autowired
     private  ProductDetailRepository productDetailRepository;
    public List<ProductDetailProjection> getProductDetailsWithVariants(int limit) {
        return productDetailRepository.findProductDetailsWithVariants(limit);
    }
}
