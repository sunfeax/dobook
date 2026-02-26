package com.sunfeax.dobook.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunfeax.dobook.entity.ResourceEntity;
import com.sunfeax.dobook.service.ResourceService;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping
    public List<ResourceEntity> getResources() {
        return resourceService.getAll();
    }

    @GetMapping("/venue/{venueId}")
    public List<ResourceEntity> getResourcesByVenue(@PathVariable Long venueId) {
        return resourceService.getAllByVenueId(venueId);
    }
}
