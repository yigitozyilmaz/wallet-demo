package com.example.odev.webApiControllers;

import com.example.odev.Entity.Flight;
import com.example.odev.business.requests.FlightRequest;
import com.example.odev.mappers.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody FlightRequest flightRequest) {
        // FlightRequest'ten Flight nesnesine dönüşüm yap
        Flight flight = new Flight(
                flightRequest.getName(),
                flightRequest.getFlightDate(),
                flightRequest.getDeparturePort(),
                flightRequest.getArrivalPort(),
                flightRequest.getPersonCount(),
                flightRequest.getVip_status(),
                flightRequest.getLuggage()
        );
        Flight savedFlight = flightService.saveFlight(flight);
        return ResponseEntity.ok(savedFlight);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Flight>> getFlightsByName(@RequestParam String name) {
        List<Flight> flights = flightService.getFlightsByName(name);
        return ResponseEntity.ok(flights);
    }
}
