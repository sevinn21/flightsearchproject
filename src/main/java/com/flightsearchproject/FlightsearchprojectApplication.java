package com.flightsearchproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FlightsearchprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightsearchprojectApplication.class, args);
    }

}
