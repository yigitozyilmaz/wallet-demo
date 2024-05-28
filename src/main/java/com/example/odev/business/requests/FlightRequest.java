package com.example.odev.business.requests;

import lombok.Data;

import java.util.Date;

@Data
public class FlightRequest {
    private String name;
    private Date flightDate;
    private String departurePort;
    private String arrivalPort;
    private Long personCount;
    private Long vip_status;
    private Long luggage;
}