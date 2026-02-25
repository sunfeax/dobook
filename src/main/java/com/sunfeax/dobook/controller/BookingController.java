package com.sunfeax.dobook.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.sunfeax.dobook.entity.BookingEntity;
import com.sunfeax.dobook.service.BookingService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public List<BookingEntity> getUsers() {
        return bookingService.getAll();
    }
}
