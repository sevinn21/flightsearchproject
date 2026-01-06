package com.flightsearchproject.aop.aspect;

import com.flightsearchproject.aop.annotation.FlightLoggable;
import com.flightsearchproject.service.FlightLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FlightLoggingAspect {

    private final FlightLogService logService;

    public FlightLoggingAspect(FlightLogService logService) {
        this.logService = logService;
    }

    @Around("@annotation(flightLoggable)")
    public Object logFlight(
            ProceedingJoinPoint joinPoint,
            FlightLoggable flightLoggable
    ) throws Throwable {

        Object request = joinPoint.getArgs()[0];
        Object response = null;

        try {
            response = joinPoint.proceed();
            return response;
        } finally {
            logService.log(
                    flightLoggable.serviceName(),
                    flightLoggable.provider(),
                    request,
                    response
            );
        }
    }
}
