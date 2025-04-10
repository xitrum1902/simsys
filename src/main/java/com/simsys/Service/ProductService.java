package com.inventory.service;

import com.inventory.model.Product;
import com.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;

    public Product save(Product p) {
        return productRepo.save(p);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Product update(Long id, Product updated) {
        Product p = productRepo.findById(id).orElseThrow();
        p.setName(updated.getName());
        p.setSku(updated.getSku());
        p.setCategory(updated.getCategory());
        p.setPrice(updated.getPrice());
        p.setQuantity(updated.getQuantity());
        p.setSupplier(updated.getSupplier());
        return productRepo.save(p);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}