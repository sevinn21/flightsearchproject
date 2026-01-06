package com.flightsearchproject.service;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a unique key used to group or identify identical flights.
 */


public class FlightGroupKey {

    private final String flightNo;
    private final String origin;
    private final String destination;
    private final LocalDateTime departureDateTime;
    private final LocalDateTime arrivalDateTime;

    public FlightGroupKey(
            String flightNo,
            String origin,
            String destination,
            LocalDateTime departureDateTime,
            LocalDateTime arrivalDateTime
    ) {
        this.flightNo = flightNo;
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightGroupKey)) return false;
        FlightGroupKey that = (FlightGroupKey) o;
        return Objects.equals(flightNo, that.flightNo)
                && Objects.equals(origin, that.origin)
                && Objects.equals(destination, that.destination)
                && Objects.equals(departureDateTime, that.departureDateTime)
                && Objects.equals(arrivalDateTime, that.arrivalDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                flightNo,
                origin,
                destination,
                departureDateTime,
                arrivalDateTime
        );
    }
}
