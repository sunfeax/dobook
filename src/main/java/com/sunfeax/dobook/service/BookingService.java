package com.sunfeax.dobook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunfeax.dobook.dto.booking.BookingResponseDto;
import com.sunfeax.dobook.mapper.BookingMapper;
import com.sunfeax.dobook.repository.BookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Transactional(readOnly = true)
    public List<BookingResponseDto> getAll() {
        return bookingRepository.findAll()
            .stream()
            .map(bookingMapper::toResponseDto)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<BookingResponseDto> getById(Long id) {
        return bookingRepository.findById(id)
            .map(bookingMapper::toResponseDto);
    }
}
