package com.flightsearchproject.controller;

import com.flightsearchproject.client.providera.ProviderASoapClient;
import com.flightsearchproject.client.providera.SearchRequestA;
import com.flightsearchproject.client.providera.SearchResponseA;
import com.flightsearchproject.client.providerb.ProviderBSoapClient;
import com.flightsearchproject.client.providerb.SearchRequestB;
import com.flightsearchproject.client.providerb.SearchResponseB;
import com.flightsearchproject.dto.FlightDto;
import com.flightsearchproject.dto.request.FlightSearchRequest;
import com.flightsearchproject.mapper.FlightMapper;
import com.flightsearchproject.service.FlightSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightSearchController {

    private final ProviderASoapClient aClient;
    private final ProviderBSoapClient bClient;
    private final FlightMapper mapper;
    private final FlightSearchService flightService;

    public FlightSearchController(
            ProviderASoapClient aClient,
            ProviderBSoapClient bClient,
            FlightMapper mapper,
            FlightSearchService flightService) {

        this.aClient = aClient;
        this.bClient = bClient;
        this.mapper = mapper;
        this.flightService = flightService;
    }


    @PostMapping("/search")
    public List<FlightDto> search(@RequestBody FlightSearchRequest req) {

        SearchRequestA aReq =
                new SearchRequestA(
                        req.getOrigin(),
                        req.getDestination(),
                        req.getDepartureDate()
                );


        SearchRequestB bReq =
                new SearchRequestB(
                        req.getOrigin(),
                        req.getDestination(),
                        req.getDepartureDate()
                );


        List<FlightDto> result = new ArrayList<>();
        result.addAll(mapper.fromProviderA(aClient.search(aReq)));
        result.addAll(mapper.fromProviderB(bClient.search(bReq)));

        return result;
    }


    @PostMapping("/search/cheapest")
    public List<FlightDto> searchCheapest(
            @RequestBody FlightSearchRequest req) {

        SearchRequestA aReq =
                new SearchRequestA(
                        req.getOrigin(),
                        req.getDestination(),
                        req.getDepartureDate()
                );

        SearchResponseA aRes = aClient.search(aReq);


        SearchRequestB bReq =
                new SearchRequestB(
                        req.getOrigin(),
                        req.getDestination(),
                        req.getDepartureDate()
                );

        SearchResponseB bRes = bClient.search(bReq);


        List<FlightDto> aFlights = mapper.fromProviderA(aRes);

        List<FlightDto> bFlights = mapper.fromProviderB(bRes);

        List<FlightDto> result = flightService.mergeAndSelectCheapest(aFlights, bFlights);
        return result;
    }
}
