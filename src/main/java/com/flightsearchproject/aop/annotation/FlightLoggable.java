package com.flightsearchproject.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FlightLoggable {
    String serviceName();
    String provider();
}
