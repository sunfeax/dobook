package com.sunfeax.dobook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunfeax.dobook.dto.venue.VenueResponseDto;
import com.sunfeax.dobook.mapper.VenueMapper;
import com.sunfeax.dobook.repository.VenueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;

    @Transactional(readOnly = true)
    public List<VenueResponseDto> getAll() {
        return venueRepository.findAll()
            .stream()
            .map(venueMapper::toResponseDto)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<VenueResponseDto> getById(Long id) {
        return venueRepository.findById(id)
            .map(venueMapper::toResponseDto);
    }
}
