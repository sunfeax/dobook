package com.sunfeax.dobook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunfeax.dobook.dto.offering.OfferingResponseDto;
import com.sunfeax.dobook.mapper.OfferingMapper;
import com.sunfeax.dobook.repository.OfferingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfferingService {

    private final OfferingRepository offeringRepository;
    private final OfferingMapper offeringMapper;

    @Transactional(readOnly = true)
    public List<OfferingResponseDto> getAll() {
        return offeringRepository.findAll()
            .stream()
            .map(offeringMapper::toResponseDto)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<OfferingResponseDto> getById(Long id) {
        return offeringRepository.findById(id)
            .map(offeringMapper::toResponseDto);
    }
}
