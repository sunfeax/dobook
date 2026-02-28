package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.venue.VenueResponseDto;
import com.sunfeax.dobook.entity.VenueEntity;

@Component
public class VenueMapper {

    public VenueResponseDto toResponseDto(VenueEntity venueEntity) {
        return new VenueResponseDto(
            venueEntity.getId(),
            venueEntity.getName(),
            venueEntity.getAddress(),
            venueEntity.getDescription(),
            venueEntity.getAdminUser().getUsername(),
            venueEntity.getAdminUser().getPhoneNumber(),
            venueEntity.getCreatedAt()
        );
    }
}
