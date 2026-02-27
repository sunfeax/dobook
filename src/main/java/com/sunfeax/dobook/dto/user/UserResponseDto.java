package com.sunfeax.dobook.dto.user;

import java.time.LocalDateTime;

import com.sunfeax.dobook.enums.UserRole;

public record UserResponseDto(
    Long id,
    String username,
    String email,
    UserRole role,
    LocalDateTime createdAt) {
}
