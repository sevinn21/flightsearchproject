package com.flightsearchproject.dto.response;

import com.flightsearchproject.dto.FlightDto;

import java.util.List;

public class FlightSearchResponse {

    private boolean hasError;
    private String errorMessage;
    private List<FlightDto> flights;

    public FlightSearchResponse() {
    }

    public FlightSearchResponse(boolean hasError, String errorMessage, List<FlightDto> flights) {
        this.hasError = hasError;
        this.errorMessage = errorMessage;
        this.flights = flights;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<FlightDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDto> flights) {
        this.flights = flights;
    }
}
