package com.flightsearchproject.repository;

import com.flightsearchproject.entity.FlightSearchLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightSearchLogRepository
        extends JpaRepository<FlightSearchLog, Long> {
}

