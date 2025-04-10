package com.inventory.service;

import com.inventory.dto.ProductDTO;
import com.inventory.model.Product;
import com.inventory.model.Supplier;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;
    private final SupplierRepository supplierRepo;

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

    public ProductDTO toDTO(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setSku(p.getSku());
        dto.setCategory(p.getCategory());
        dto.setPrice(p.getPrice());
        dto.setQuantity(p.getQuantity());
        dto.setSupplierId(p.getSupplier() != null ? p.getSupplier().getId() : null);
        return dto;
    }

    public Product fromDTO(ProductDTO dto) {
        Product p = new Product();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setSku(dto.getSku());
        p.setCategory(dto.getCategory());
        p.setPrice(dto.getPrice());
        p.setQuantity(dto.getQuantity());
        if (dto.getSupplierId() != null) {
            Supplier supplier = supplierRepo.findById(dto.getSupplierId()).orElseThrow();
            p.setSupplier(supplier);
        }
        return p;
    }
}