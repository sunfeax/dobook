package com.sunfeax.dobook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunfeax.dobook.dto.venue.VenueResponseDto;
import com.sunfeax.dobook.service.VenueService;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @GetMapping
    public List<VenueResponseDto> getVenue() {
        return venueService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueResponseDto> getVenueById(@PathVariable Long id) {
        return ResponseEntity.of(venueService.getById(id));
    }
}
