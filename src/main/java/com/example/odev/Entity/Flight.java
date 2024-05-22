package com.example.odev.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "flights", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "flight_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date flightDate;

    @Column(name = "depp_port", nullable = false, unique = true)
    private String departurePort;

    @Column(name = "arr_port", nullable = false, unique = true)
    private String arrivalPort;

    @Column(name = "person_count", nullable = false)
    private Long personCount;

    // Constructor with id excluded
    public Flight(String name, Date flightDate, String departurePort, String arrivalPort, Long personCount) {
        this.name = name;
        this.flightDate = flightDate;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.personCount = personCount;
    }
}