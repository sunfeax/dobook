package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.resource.ResourceResponseDto;
import com.sunfeax.dobook.entity.ResourceEntity;

@Component
public class ResourceMapper {

    public ResourceResponseDto toResponseDto(ResourceEntity resourceEntity) {
        return new ResourceResponseDto(
            resourceEntity.getId(),
            resourceEntity.getName(),
            resourceEntity.getType(),
            resourceEntity.getDescription(),
            resourceEntity.getCapacity(),
            resourceEntity.isActive(),
            resourceEntity.getVenue().getName()
        );
    }
}
