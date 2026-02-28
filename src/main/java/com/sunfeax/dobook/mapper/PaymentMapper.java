package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.payment.PaymentResponseDto;
import com.sunfeax.dobook.entity.PaymentEntity;

@Component
public class PaymentMapper {

    public PaymentResponseDto toResponseDto(PaymentEntity paymentEntity) {
        return new PaymentResponseDto(
            paymentEntity.getId(),
            paymentEntity.getBooking().getId(),
            paymentEntity.getAmount(),
            paymentEntity.getCurrency(),
            paymentEntity.getStatus(),
            paymentEntity.getCreatedAt(),
            paymentEntity.getUpdatedAt()
        );
    }
}
