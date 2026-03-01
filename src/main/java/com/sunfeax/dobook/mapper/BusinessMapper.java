package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.business.BusinessResponseDto;
import com.sunfeax.dobook.entity.BusinessEntity;

@Component
public class BusinessMapper {

    public BusinessResponseDto toResponseDto(BusinessEntity businessEntity) {
        return new BusinessResponseDto(
            businessEntity.getId(),
            businessEntity.getName(),
            businessEntity.getDescription(),
            businessEntity.getPhone(),
            businessEntity.getEmail(),
            businessEntity.getWebsite(),
            businessEntity.getAddress(),
            businessEntity.isActive(),
            businessEntity.getOwner().getId(),
            businessEntity.getOwner().getUsername(),
            businessEntity.getCreatedAt(),
            businessEntity.getUpdatedAt()
        );
    }
}
