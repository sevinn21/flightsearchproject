package com.flightsearchproject.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Configures SOAP clients and WebServiceTemplates for different flight providers.
 */

@Configuration
public class SoapClientConfig {

    // ---------- Provider A ----------
    @Bean
    public Jaxb2Marshaller providerAMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(
                com.flightsearchproject.client.providera.SearchRequestA.class,
                com.flightsearchproject.client.providera.SearchResponseA.class,
                com.flightsearchproject.client.providera.Flight.class
        );
        return marshaller;
    }

    @Bean
    public WebServiceTemplate providerAWebServiceTemplate(
            @Qualifier("providerAMarshaller") Jaxb2Marshaller marshaller
    ) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri("http://localhost:8081/ws"); // ProviderA endpoint
        return template;
    }

    // ---------- Provider B ----------
    @Bean
    public Jaxb2Marshaller providerBMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(
                com.flightsearchproject.client.providerb.SearchRequestB.class,
                com.flightsearchproject.client.providerb.SearchResponseB.class,
                com.flightsearchproject.client.providerb.Flight.class
        );
        return marshaller;
    }

    @Bean
    public WebServiceTemplate providerBWebServiceTemplate(
            @Qualifier("providerBMarshaller") Jaxb2Marshaller marshaller
    ) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri("http://localhost:8083/ws"); // ProviderB endpoint
        return template;
    }
}
