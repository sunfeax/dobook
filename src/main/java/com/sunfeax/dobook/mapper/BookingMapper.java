package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.booking.BookingResponseDto;
import com.sunfeax.dobook.entity.BookingEntity;

@Component
public class BookingMapper {

    public BookingResponseDto toResponseDto(BookingEntity bookingEntity) {
        return new BookingResponseDto(
            bookingEntity.getId(),
            bookingEntity.getUser().getUsername(),
            bookingEntity.getUser().getEmail(),
            bookingEntity.getVenue().getName(),
            bookingEntity.getResource().getName(),
            bookingEntity.getStartTime(),
            bookingEntity.getEndTime(),
            bookingEntity.getStatus()
        );
    }
}
