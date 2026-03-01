package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.service.ServiceResponseDto;
import com.sunfeax.dobook.entity.ServiceEntity;

@Component
public class ServiceMapper {

    public ServiceResponseDto toResponseDto(ServiceEntity serviceEntity) {
        return new ServiceResponseDto(
            serviceEntity.getId(),
            serviceEntity.getName(),
            serviceEntity.getBusiness().getName(),
            serviceEntity.getDescription(),
            serviceEntity.getPriceAmount(),
            serviceEntity.getDurationMinutes(),
            serviceEntity.isActive(),
            serviceEntity.getCreatedAt()
        );
    }
}
