package com.sunfeax.dobook.dto.booking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sunfeax.dobook.enums.BookingStatus;
import com.sunfeax.dobook.enums.PaymentMethod;

public record BookingResponseDto(
    Long id,
    String user,
    String userEmail,
    String venue,
    String resource,
    BigDecimal priceAmount,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BookingStatus status,
    PaymentMethod paymentMethod) {
}
