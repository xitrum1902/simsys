package com.simsys.warehouse.service;

import com.simsys.warehouse.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public List<ProductEntity> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    public List<ProductEntity> getLowStockProducts(int minStock) {
//        return productRepository.findByQuantityLessThan(minStock);
//    }

}
