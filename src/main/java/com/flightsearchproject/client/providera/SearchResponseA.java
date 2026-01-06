package com.flightsearchproject.client.providera;

import jakarta.xml.bind.annotation.*;

import java.util.List;


@XmlRootElement(name = "SearchResponse", namespace = "http://flightprovidera.com/flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResponseA {

    private boolean hasError;

    @XmlElementWrapper(name = "flightOptions")
    @XmlElement(name = "flight")
    private List<Flight> flightOptions;

    private String errorMessage;

    public SearchResponseA() {}

    public SearchResponseA(boolean hasError, List<Flight> flightOptions, String errorMessage) {
        this.hasError = hasError;
        this.flightOptions = flightOptions;
        this.errorMessage = errorMessage;
    }


    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public List<Flight> getFlightOptions() {
        return flightOptions;
    }

    public void setFlightOptions(List<Flight> flightOptions) {
        this.flightOptions = flightOptions;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
