package com.flightsearchproject.client.providera;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SearchRequest", namespace = "http://flightprovidera.com/flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchRequestA {

    private String origin;
    private String destination;
    private String departureDate;

    public SearchRequestA() {}

    public SearchRequestA(String origin, String destination, String departureDate) {
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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

