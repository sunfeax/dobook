package com.sunfeax.dobook.dto.booking;

import java.time.LocalDateTime;

import com.sunfeax.dobook.enums.BookingStatus;

public record BookingResponseDto(
    Long id,
    String user,
    String userEmail,
    String venue,
    String resource,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BookingStatus status) {
}
