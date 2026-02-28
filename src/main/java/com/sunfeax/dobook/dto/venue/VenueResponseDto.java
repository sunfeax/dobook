package com.sunfeax.dobook.dto.venue;

import java.time.LocalDateTime;

public record VenueResponseDto(
    Long id,
    String name,
    String address,
    String description,
    String adminName,
    String adminPhone,
    LocalDateTime createdAt) {
}
