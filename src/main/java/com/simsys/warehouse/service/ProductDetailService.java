package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.ProductDetailDTO;
import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.ProductDetailVariantValueEntity;
import com.simsys.warehouse.mapper.ProductDetailMapper;
import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.repository.ProductDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDetailService {

    final private  ProductDetailRepository productDetailRepository;

    public ProductDetailService(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    public List<ProductDetailProjection> getProductDetailsWithVariants(int limit) {
        return productDetailRepository.findProductDetailsWithVariants(limit);
    }
    public ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO) {
        ProductDetailEntity entity = ProductDetailMapper.toEntity(productDetailDTO);
        ProductDetailEntity savedEntity = productDetailRepository.save(entity);
        return ProductDetailMapper.toDTO(savedEntity);
    }

    public ProductDetailDTO getProductDetailById(Integer id) {
        ProductDetailEntity entity = productDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductDetail not found with id: " + id));
        return ProductDetailMapper.toDTO(entity);
    }

    public List<ProductDetailDTO> getAllProductDetails() {
        List<ProductDetailEntity> entities = productDetailRepository.findAll();
        return entities.stream()
                .map(ProductDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDetailDTO updateProductDetail(Integer id, ProductDetailDTO productDetailDTO) {
        ProductDetailEntity existingEntity = productDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductDetail not found with id: " + id));

        // Update entity fields
        existingEntity.setTotalQuantity(productDetailDTO.getTotalQuantity());
        if (productDetailDTO.getProductId() != null) {
            existingEntity.getProduct().setProductid(productDetailDTO.getProductId());
        }

        if (productDetailDTO.getVariantValueIds() != null) {
            List<ProductDetailVariantValueEntity> updatedVariantValues = productDetailDTO.getVariantValueIds().stream().map(variantId -> {
                ProductDetailVariantValueEntity variantValue = new ProductDetailVariantValueEntity();
                variantValue.setId(variantId);
                return variantValue;
            }).collect(Collectors.toList());
            existingEntity.setVariantValues(updatedVariantValues);
        }

        ProductDetailEntity updatedEntity = productDetailRepository.save(existingEntity);
        return ProductDetailMapper.toDTO(updatedEntity);
    }

    public void deleteProductDetail(Integer id) {
        ProductDetailEntity entity = productDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductDetail not found with id: " + id));
        productDetailRepository.delete(entity);
    }

    public Optional<ProductDetailEntity> getProductById(Integer id) {
        return  productDetailRepository.findById(id);
    }

}
