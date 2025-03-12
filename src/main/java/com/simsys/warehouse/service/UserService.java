package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> findById(Integer userId) {
        return userRepository.findById(userId);
    }
}
