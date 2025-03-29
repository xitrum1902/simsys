package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.VariantDTO;
import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.mapper.VariantMapper;
import com.simsys.warehouse.repository.VariantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VariantService {

    private final VariantRepository variantRepository;

    public VariantService(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    public VariantDTO createVariant(VariantDTO dto) {
        VariantEntity entity = VariantMapper.toEntity(dto);
        return VariantMapper.toDTO(variantRepository.save(entity));
    }

    public List<VariantDTO> getAllVariants() {
        return variantRepository.findAll().stream()
                .map(VariantMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VariantDTO getVariantById(Integer id) {
        VariantEntity entity = variantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found with ID: " + id));
        return VariantMapper.toDTO(entity);
    }

    public VariantDTO updateVariant(Integer id, VariantDTO dto) {
        VariantEntity existingEntity = variantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found with ID: " + id));

        existingEntity.setName(dto.getName());

        return VariantMapper.toDTO(variantRepository.save(existingEntity));
    }

    public void deleteVariant(Integer id) {
        VariantEntity existingEntity = variantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found with ID: " + id));
        variantRepository.delete(existingEntity);
    }
}
