package com.flightsearchproject.client.providera;

import com.flightsearchproject.aop.annotation.FlightLoggable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class ProviderASoapClient {

    private final WebServiceTemplate ws;

    public ProviderASoapClient(
            @Qualifier("providerAWebServiceTemplate")
            WebServiceTemplate ws
    ) {
        this.ws = ws;
    }

    @FlightLoggable(
            serviceName = "SEARCH_CHEAPEST",
            provider = "PROVIDER_A"
    )
    public SearchResponseA search(SearchRequestA req) {
        return (SearchResponseA) ws.marshalSendAndReceive(
                "http://localhost:8081/ws",
                req
        );
    }
}



