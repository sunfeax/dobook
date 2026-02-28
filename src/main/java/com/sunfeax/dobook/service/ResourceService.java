package com.sunfeax.dobook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunfeax.dobook.dto.resource.ResourceResponseDto;
import com.sunfeax.dobook.mapper.ResourceMapper;
import com.sunfeax.dobook.repository.ResourceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Transactional(readOnly = true)
    public List<ResourceResponseDto> getAll() {
        return resourceRepository.findAll()
            .stream()
            .map(resourceMapper::toResponseDto)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ResourceResponseDto> getById(Long id) {
        return resourceRepository.findById(id)
            .map(resourceMapper::toResponseDto);
    }

    // public List<ResourceEntity> getAllByVenueId(Long venueId) {
    //     return resourceRepository.findByVenueId(venueId);
    // }
}
