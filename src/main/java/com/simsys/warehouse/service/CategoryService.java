package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.CategoryDTO;
import com.simsys.warehouse.entity.CategoryEntity;
import com.simsys.warehouse.entity.ProductEntity;
import com.simsys.warehouse.mapper.CategoryMapper;
import com.simsys.warehouse.repository.CategoryRepository;
import com.simsys.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(Integer id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDTO)
                .orElse(null);
    }

    public CategoryDTO create(CategoryDTO dto) {
        ProductEntity productEntity = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        CategoryEntity entity = CategoryMapper.toEntity(dto, productEntity);
        CategoryEntity savedEntity = categoryRepository.save(entity);
        return CategoryMapper.toDTO(savedEntity);
    }

    public CategoryDTO update(Integer id, CategoryDTO dto) {
        CategoryEntity existingEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        ProductEntity productEntity = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        existingEntity.setName(dto.getName());
        existingEntity.setProductid(productEntity);

        CategoryEntity updatedEntity = categoryRepository.save(existingEntity);
        return CategoryMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
