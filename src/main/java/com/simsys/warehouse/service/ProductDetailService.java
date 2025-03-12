package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService {
    @Autowired
     private  ProductDetailRepository productDetailRepository;
    public List<ProductDetailProjection> getProductDetailsWithVariants(int limit) {
        return productDetailRepository.findProductDetailsWithVariants(limit);
    }
    public Optional<ProductDetailEntity> findById(Integer userId) {
        return productDetailRepository.findById(userId);
    }
}
