# Flight Search Project

This project exposes a REST API that aggregates flight availability data from two different SOAP providers.

---

## Overview

- A REST service receives flight search requests  
- It calls two external SOAP services (Provider A & Provider B)  
- SOAP responses are converted into a common response model  
- Aggregated result is returned to the client  
- Request and response data are logged to the database  

---

## Projects

### FlightSearch REST API
- REST endpoint for flight search  
- SOAP clients for Provider A and Provider B  
- Response aggregation and mapping  
- Logging implemented using AOP and async execution  

### Provider A / Provider B
- Independent SOAP services  
- Contract-first approach using XSD  
- WSDL generated automatically by Spring WS  

---

## Technologies

- Java  
- Spring Boot  
- Spring Web (REST)  
- Spring Web Services (SOAP)  
- Spring Data JPA  
- PostgreSQL  
- Maven  

---

## Notes

- Providers simulate real external SOAP systems  
- Logging does not affect the main business flow  
- XSD is used to keep SOAP contracts stable  
