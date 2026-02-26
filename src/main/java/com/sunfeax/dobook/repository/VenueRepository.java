package com.sunfeax.dobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunfeax.dobook.entity.VenueEntity;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Long> {
}
