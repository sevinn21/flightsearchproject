package com.flightsearchproject.mapper;


import com.flightsearchproject.client.providera.SearchResponseA;
import com.flightsearchproject.dto.FlightDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightMapper {

    public List<FlightDto> fromProviderA(SearchResponseA res) {
        return res.getFlightOptions().stream()
                .map(f -> new FlightDto(
                        f.getFlightNo(),
                        f.getOrigin(),
                        f.getDestination(),
                        f.getDepartureDateTime(),
                        f.getArrivalDateTime(),
                        f.getPrice() != null ? f.getPrice().doubleValue() : 0.0
                ))
                .toList();
    }

    public List<FlightDto> fromProviderB(com.flightsearchproject.client.providerb.SearchResponseB res) {
        return res.getFlightOptions().stream()
                .map(f -> new FlightDto(
                        f.getFlightNumber(),
                        f.getDeparture(),
                        f.getArrival(),
                        f.getDepartureDateTime(),
                        f.getArrivalDateTime(),
                        f.getPrice()
                ))
                .toList();
    }
}

