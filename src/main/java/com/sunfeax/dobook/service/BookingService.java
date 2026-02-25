package com.sunfeax.dobook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunfeax.dobook.entity.BookingEntity;
import com.sunfeax.dobook.repository.BookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<BookingEntity> getAll() {
        return bookingRepository.findAll();
    }
}
