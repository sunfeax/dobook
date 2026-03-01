package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.offering.OfferingResponseDto;
import com.sunfeax.dobook.entity.OfferingEntity;

@Component
public class OfferingMapper {

    public OfferingResponseDto toResponseDto(OfferingEntity offeringEntity) {
        return new OfferingResponseDto(
            offeringEntity.getId(),
            offeringEntity.getBusiness().getId(),
            offeringEntity.getBusiness().getName(),
            offeringEntity.getSpecialist().getId(),
            offeringEntity.getSpecialist().getUsername(),
            offeringEntity.getService().getId(),
            offeringEntity.getService().getName(),
            offeringEntity.getPriceAmount(),
            offeringEntity.getDurationMinutes(),
            offeringEntity.isActive(),
            offeringEntity.getCreatedAt()
        );
    }
}
