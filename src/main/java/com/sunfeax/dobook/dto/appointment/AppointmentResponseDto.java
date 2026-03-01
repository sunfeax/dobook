package com.sunfeax.dobook.dto.appointment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sunfeax.dobook.enums.AppointmentStatus;
import com.sunfeax.dobook.enums.PaymentMethod;

public record AppointmentResponseDto(
    Long id,
    Long clientId,
    String clientName,
    String clientEmail,
    Long offeringId,
    Long specialistId,
    String specialistName,
    Long serviceId,
    String serviceName,
    String businessName,
    LocalDateTime startTime,
    LocalDateTime endTime,
    AppointmentStatus status,
    PaymentMethod paymentMethod,
    BigDecimal priceAmount) {
}
