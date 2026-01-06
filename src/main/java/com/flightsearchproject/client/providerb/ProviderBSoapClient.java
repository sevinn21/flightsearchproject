package com.flightsearchproject.client.providerb;

import com.flightsearchproject.aop.annotation.FlightLoggable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class ProviderBSoapClient {

    private final WebServiceTemplate ws;

    public ProviderBSoapClient(
            @Qualifier("providerBWebServiceTemplate")
            WebServiceTemplate ws
    ) {
        this.ws = ws;
    }

    @FlightLoggable(
            serviceName = "SEARCH_CHEAPEST",
            provider = "PROVIDER_B"
    )
    public SearchResponseB search(SearchRequestB req) {
        return (SearchResponseB) ws.marshalSendAndReceive(
                "http://localhost:8083/ws",
                req
        );
    }
}


