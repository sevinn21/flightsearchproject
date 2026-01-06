package com.flightsearchproject.service;

import com.flightsearchproject.entity.FlightSearchLog;
import com.flightsearchproject.repository.FlightSearchLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FlightLogService {

    private final FlightSearchLogRepository repo;
    private final ObjectMapper mapper;

    public FlightLogService(FlightSearchLogRepository repo,
                            ObjectMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Async
    public void log(String serviceName, String provider,
                    Object request, Object response) {

        try {
            FlightSearchLog log = new FlightSearchLog();
            log.setServiceName(serviceName);
            log.setProvider(provider);
            log.setRequestPayload(mapper.writeValueAsString(request));
            log.setResponsePayload(mapper.writeValueAsString(response));

            repo.save(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
