package com.sunfeax.dobook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunfeax.dobook.entity.VenueEntity;
import com.sunfeax.dobook.repository.VenueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;

    public List<VenueEntity> getAll() {
        return venueRepository.findAll();
    }
}
