package com.sunfeax.dobook.mapper;

import org.springframework.stereotype.Component;

import com.sunfeax.dobook.dto.appointment.AppointmentResponseDto;
import com.sunfeax.dobook.entity.AppointmentEntity;

@Component
public class AppointmentMapper {

    public AppointmentResponseDto toResponseDto(AppointmentEntity appointmentEntity) {
        return new AppointmentResponseDto(
            appointmentEntity.getId(),
            appointmentEntity.getClient().getId(),
            appointmentEntity.getClient().getUsername(),
            appointmentEntity.getClient().getEmail(),
            appointmentEntity.getOffering().getId(),
            appointmentEntity.getOffering().getSpecialist().getId(),
            appointmentEntity.getOffering().getSpecialist().getUsername(),
            appointmentEntity.getOffering().getService().getId(),
            appointmentEntity.getOffering().getService().getName(),
            appointmentEntity.getOffering().getBusiness().getName(),
            appointmentEntity.getStartTime(),
            appointmentEntity.getEndTime(),
            appointmentEntity.getStatus(),
            appointmentEntity.getPaymentMethod(),
            appointmentEntity.getPriceAmount()
        );
    }
}
