package com.flightsearchproject.adapter;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

/**
 * Converts LocalDateTime between its Java form and XML string value.
 */

public class LocalDateTimeAdapter
        extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String value) {
        return LocalDateTime.parse(value);
    }

    @Override
    public String marshal(LocalDateTime value) {
        return value.toString();
    }
}
