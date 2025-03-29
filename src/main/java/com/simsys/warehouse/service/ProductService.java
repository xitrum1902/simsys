package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.ProductDTO;
import com.simsys.warehouse.entity.ProductEntity;
import com.simsys.warehouse.mapper.ProductMapper;
import com.simsys.warehouse.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductMapper.toEntity(productDTO);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return ProductMapper.toDTO(savedEntity);
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> entities = productRepository.findAll();
        return entities.stream().map(ProductMapper::toDTO).toList();
    }

    public ProductDTO getProductById(int id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ProductMapper.toDTO(optionalProduct.get());
        } else {
            throw new RuntimeException("Product with ID " + id + " not found.");
        }
    }

    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity existingProduct = optionalProduct.get();
            existingProduct.setName(productDTO.getName());
            existingProduct.setSaleprice(productDTO.getSaleprice());
            existingProduct.setQuantity(productDTO.getQuantity());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setStatus(productDTO.isStatus());
            existingProduct.setConsignmentid(productDTO.getConsignmentid());

            ProductEntity updatedEntity = productRepository.save(existingProduct);
            return ProductMapper.toDTO(updatedEntity);
        } else {
            throw new RuntimeException("Product with ID " + id + " not found.");
        }
    }

    public void deleteProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product with ID " + id + " not found.");
        }
    }

}
