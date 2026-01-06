package com.flightsearchproject.client.providerb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SearchRequest", namespace = "http://flightproviderb.com/flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchRequestB {

    private String departure;
    private String arrival;
    private String departureDate;

    public SearchRequestB() {}

    public SearchRequestB(String departure, String arrival, String departureDate) {
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
    }



    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
}

