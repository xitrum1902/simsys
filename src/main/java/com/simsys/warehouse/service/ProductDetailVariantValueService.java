package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.ProductDetailVariantValueDTO;
import com.simsys.warehouse.entity.ProductDetailVariantValueEntity;
import com.simsys.warehouse.mapper.ProductDetailVariantValueMapper;
import com.simsys.warehouse.repository.ProductDetailRepository;
import com.simsys.warehouse.repository.ProductDetailVariantValueRepository;
import com.simsys.warehouse.repository.VariantValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDetailVariantValueService {

    @Autowired
    private ProductDetailVariantValueRepository productDetailVariantValueRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private VariantValueRepository variantValueRepository;

    public List<ProductDetailVariantValueDTO> findAll() {
        return productDetailVariantValueRepository.findAll().stream()
                .map(ProductDetailVariantValueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDetailVariantValueDTO findById(Integer id) {
        return productDetailVariantValueRepository.findById(id)
                .map(ProductDetailVariantValueMapper::toDTO)
                .orElse(null);
    }

    public ProductDetailVariantValueDTO create(ProductDetailVariantValueDTO dto) {
        ProductDetailVariantValueEntity entity = ProductDetailVariantValueMapper.toEntity(dto);
        entity.setProductDetail(productDetailRepository.findById(dto.getProductDetailId()).orElse(null));
        entity.setVariantValue(variantValueRepository.findById(dto.getVariantValueId()).orElse(null));
        ProductDetailVariantValueEntity savedEntity = productDetailVariantValueRepository.save(entity);
        return ProductDetailVariantValueMapper.toDTO(savedEntity);
    }

    public ProductDetailVariantValueDTO update(Integer id, ProductDetailVariantValueDTO dto) {
        ProductDetailVariantValueEntity entity = productDetailVariantValueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product Detail Variant Value not found"));

        entity.setProductDetail(productDetailRepository.findById(dto.getProductDetailId()).orElse(null));
        entity.setVariantValue(variantValueRepository.findById(dto.getVariantValueId()).orElse(null));
        ProductDetailVariantValueEntity updatedEntity = productDetailVariantValueRepository.save(entity);
        return ProductDetailVariantValueMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        productDetailVariantValueRepository.deleteById(id);
    }
}
