package com.sunfeax.dobook.dto.resource;

import com.sunfeax.dobook.enums.ResourceType;

public record ResourceResponseDto(
    Long id,
    String name,
    ResourceType type,
    String description,
    Integer capacity,
    Boolean isActive,
    String venue) {
}
