package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.UserDTO;
import com.simsys.warehouse.entity.RoleEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.mapper.UserMapper;
import com.simsys.warehouse.repository.RoleRepository;
import com.simsys.warehouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private  final UserRepository userRepository;

    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Optional<UserEntity> findById(Integer userId) {
        return userRepository.findById(userId);
    }

    public UserDTO createUser(UserDTO dto) {
        RoleEntity role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + dto.getRoleId()));

        UserEntity entity = UserMapper.toEntity(dto, role);
        return UserMapper.toDTO(userRepository.save(entity));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return UserMapper.toDTO(entity);
    }

    public UserDTO updateUser(Integer id, UserDTO dto) {
        UserEntity existingEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        RoleEntity role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + dto.getRoleId()));

        existingEntity.setUsername(dto.getUsername());
        existingEntity.setEmail(dto.getEmail());
        existingEntity.setContactInfo(dto.getContactInfo());
        existingEntity.setStatus(dto.getStatus());
        existingEntity.setRole(role);

        return UserMapper.toDTO(userRepository.save(existingEntity));
    }

    public void deleteUser(Integer id) {
        UserEntity existingEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        userRepository.delete(existingEntity);
    }


}
