package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.SystemConfigDTO;
import com.simsys.warehouse.entity.SystemConfigEntity;
import com.simsys.warehouse.mapper.SystemConfigMapper;
import com.simsys.warehouse.repository.SystemConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemConfigService {

    @Autowired
    private SystemConfigRepository systemConfigRepository;

    public List<SystemConfigDTO> findAll() {
        return systemConfigRepository.findAll().stream()
                .map(SystemConfigMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SystemConfigDTO findById(Integer id) {
        return systemConfigRepository.findById(id)
                .map(SystemConfigMapper::toDTO)
                .orElse(null);
    }

    public SystemConfigDTO create(SystemConfigDTO dto) {
        SystemConfigEntity entity = SystemConfigMapper.toEntity(dto);
        SystemConfigEntity savedEntity = systemConfigRepository.save(entity);
        return SystemConfigMapper.toDTO(savedEntity);
    }

    public SystemConfigDTO update(Integer id, SystemConfigDTO dto) {
        SystemConfigEntity existingEntity = systemConfigRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SystemConfig not found"));

        existingEntity.setName(dto.getName());
        existingEntity.setConfigvalue(dto.getConfigValue());
        existingEntity.setDescription(dto.getDescription());

        SystemConfigEntity updatedEntity = systemConfigRepository.save(existingEntity);
        return SystemConfigMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        systemConfigRepository.deleteById(id);
    }
}
