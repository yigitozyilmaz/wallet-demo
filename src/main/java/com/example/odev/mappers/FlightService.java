package com.example.odev.mappers;

import com.example.odev.Entity.Flight;
import com.example.odev.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getFlightsByName(String name) {
        return flightRepository.findByName(name);
    }
}