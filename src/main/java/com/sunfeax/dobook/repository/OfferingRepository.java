package com.sunfeax.dobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunfeax.dobook.entity.OfferingEntity;

@Repository
public interface OfferingRepository extends JpaRepository<OfferingEntity, Long> {
}
