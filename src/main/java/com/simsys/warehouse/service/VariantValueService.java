package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.VariantValueDTO;
import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.entity.VariantValueEntity;
import com.simsys.warehouse.mapper.VariantValueMapper;
import com.simsys.warehouse.repository.VariantRepository;
import com.simsys.warehouse.repository.VariantValueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VariantValueService {

    private final VariantValueRepository variantValueRepository;
    private final VariantRepository variantRepository;

    public VariantValueService(VariantValueRepository variantValueRepository, VariantRepository variantRepository) {
        this.variantValueRepository = variantValueRepository;
        this.variantRepository = variantRepository;
    }

    public VariantValueDTO createVariantValue(VariantValueDTO dto) {
        VariantEntity variantEntity = variantRepository.findById(dto.getVariantId())
                .orElseThrow(() -> new RuntimeException("Variant not found with ID: " + dto.getVariantId()));
        VariantValueEntity entity = VariantValueMapper.toEntity(dto, variantEntity);
        return VariantValueMapper.toDTO(variantValueRepository.save(entity));
    }

    public List<VariantValueDTO> getAllVariantValues() {
        return variantValueRepository.findAll().stream()
                .map(VariantValueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VariantValueDTO getVariantValueById(Integer id) {
        VariantValueEntity entity = variantValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant Value not found with ID: " + id));
        return VariantValueMapper.toDTO(entity);
    }

    public VariantValueDTO updateVariantValue(Integer id, VariantValueDTO dto) {
        VariantValueEntity existingEntity = variantValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant Value not found with ID: " + id));

        VariantEntity variantEntity = variantRepository.findById(dto.getVariantId())
                .orElseThrow(() -> new RuntimeException("Variant not found with ID: " + dto.getVariantId()));

        existingEntity.setValue(dto.getValue());
        existingEntity.setVariant(variantEntity);

        return VariantValueMapper.toDTO(variantValueRepository.save(existingEntity));
    }

    public void deleteVariantValue(Integer id) {
        VariantValueEntity existingEntity = variantValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant Value not found with ID: " + id));
        variantValueRepository.delete(existingEntity);
    }
}
