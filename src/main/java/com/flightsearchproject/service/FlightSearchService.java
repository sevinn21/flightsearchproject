package com.flightsearchproject.service;

import com.flightsearchproject.client.providera.ProviderASoapClient;
import com.flightsearchproject.client.providera.SearchRequestA;
import com.flightsearchproject.client.providerb.ProviderBSoapClient;
import com.flightsearchproject.client.providerb.SearchRequestB;
import com.flightsearchproject.dto.FlightDto;
import com.flightsearchproject.dto.request.FlightSearchRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FlightSearchService {
    private final ProviderASoapClient providerA;
    private final ProviderBSoapClient providerB;

    public FlightSearchService(ProviderASoapClient providerA,
                               ProviderBSoapClient providerB) {
        this.providerA = providerA;
        this.providerB = providerB;
    }

    public List<Object> search(FlightSearchRequest request) {

        // Provider A request
        var aReq = new SearchRequestA();
        aReq.setOrigin(request.getOrigin());
        aReq.setDestination(request.getDestination());
        aReq.setDepartureDate(request.getDepartureDate());

        // Provider B request
        var bReq = new SearchRequestB();
        bReq.setDeparture(request.getOrigin());
        bReq.setArrival(request.getDestination());
        bReq.setDepartureDate(request.getDepartureDate());


        var aRes = providerA.search(aReq);
        var bRes = providerB.search(bReq);

        List<Object> result = new ArrayList<>();
        result.addAll(aRes.getFlightOptions());
        result.addAll(bRes.getFlightOptions());
        return result;
    }

    public List<FlightDto> mergeAndSelectCheapest(
            List<FlightDto> providerAFlights,
            List<FlightDto> providerBFlights) {

        return Stream.concat(
                        providerAFlights.stream(),
                        providerBFlights.stream()
                )
                .collect(Collectors.groupingBy(
                        f -> new FlightGroupKey(
                                f.getFlightNo(),
                                f.getOrigin(),
                                f.getDestination(),
                                f.getDepartureDateTime(),
                                f.getArrivalDateTime()
                        )
                ))
                .values()
                .stream()
                .map(group ->
                        group.stream()
                                .min(Comparator.comparingDouble(FlightDto::getPrice))
                                .orElseThrow())
                .sorted(Comparator.comparingDouble(FlightDto::getPrice)) //opsiyonel
                .toList();
    }
}
