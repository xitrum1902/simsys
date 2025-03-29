package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.RoleDTO;
import com.simsys.warehouse.entity.RoleEntity;
import com.simsys.warehouse.mapper.RoleMapper;
import com.simsys.warehouse.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream()
                .map(RoleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO findById(Integer id) {
        return roleRepository.findById(id)
                .map(RoleMapper::toDTO)
                .orElse(null);
    }

    public RoleDTO create(RoleDTO roleDTO) {
        RoleEntity entity = RoleMapper.toEntity(roleDTO);
        RoleEntity savedEntity = roleRepository.save(entity);
        return RoleMapper.toDTO(savedEntity);
    }

    public RoleDTO update(Integer id, RoleDTO roleDTO) {
        RoleEntity existingEntity = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        existingEntity.setRoleName(roleDTO.getRoleName());
        existingEntity.setDescription(roleDTO.getDescription());

        RoleEntity updatedEntity = roleRepository.save(existingEntity);
        return RoleMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
