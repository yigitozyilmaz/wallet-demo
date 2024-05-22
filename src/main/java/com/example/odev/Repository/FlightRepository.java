package com.example.odev.Repository;

import com.example.odev.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByName(String name);
}
