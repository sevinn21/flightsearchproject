package com.flightsearchproject.dto.request;


public class FlightSearchRequest {
    private String origin;
    private String destination;
    private String departureDate;

    private FlightSearchRequest(){}

    public FlightSearchRequest(String origin, String destination, String departureDate) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }


}
