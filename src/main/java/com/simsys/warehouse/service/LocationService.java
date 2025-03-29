package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.LocationDTO;
import com.simsys.warehouse.entity.LocationEntity;
import com.simsys.warehouse.mapper.LocationMapper;
import com.simsys.warehouse.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<LocationDTO> findAll() {
        return locationRepository.findAll().stream()
                .map(LocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO findById(Integer id) {
        return locationRepository.findById(id)
                .map(LocationMapper::toDTO)
                .orElse(null);
    }

    public LocationDTO create(LocationDTO dto) {
        LocationEntity entity = LocationMapper.toEntity(dto);
        LocationEntity savedEntity = locationRepository.save(entity);
        return LocationMapper.toDTO(savedEntity);
    }

    public LocationDTO update(Integer id, LocationDTO dto) {
        LocationEntity existingEntity = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Location not found"));

        existingEntity.setLocationname(dto.getLocationName());
        existingEntity.setAddress(dto.getAddress());
        existingEntity.setDescription(dto.getDescription());
        existingEntity.setPhonenumber(dto.getPhoneNumber());

        LocationEntity updatedEntity = locationRepository.save(existingEntity);
        return LocationMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }
}
