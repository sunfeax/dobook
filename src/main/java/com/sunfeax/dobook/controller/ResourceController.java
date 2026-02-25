package com.sunfeax.dobook.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunfeax.dobook.entity.ResourceEntity;
import com.sunfeax.dobook.service.ResourceService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping
    public List<ResourceEntity> getUsers() {
        return resourceService.getAll();
    }
}
