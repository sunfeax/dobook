package com.sunfeax.dobook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunfeax.dobook.entity.ResourceEntity;
import com.sunfeax.dobook.repository.ResourceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public List<ResourceEntity> getAll() {
        return resourceRepository.findAll();
    }
}
