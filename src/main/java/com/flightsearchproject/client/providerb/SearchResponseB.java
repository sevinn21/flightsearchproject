package com.flightsearchproject.client.providerb;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "SearchResponse", namespace = "http://flightproviderb.com/flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResponseB {

    @XmlElementWrapper(name = "flightOptions")
    @XmlElement(name = "flight")
    private List<Flight> flightOptions;

    public SearchResponseB() {}

    public SearchResponseB(List<Flight> flightOptions) {
        this.flightOptions = flightOptions;
    }

    public List<Flight> getFlightOptions() {
        return flightOptions;
    }

    public void setFlightOptions(List<Flight> flightOptions) {
        this.flightOptions = flightOptions;
    }



}

