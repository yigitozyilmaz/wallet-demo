package com.example.odev.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "daily_schedule", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime; // LocalDateTime olarak değiştirildi

    @Column(name = "end_time")
    private LocalDateTime endTime; // LocalDateTime olarak değiştirildi

    @Column(name = "next_plan_duration")
    private Integer nextPlanDuration;

    // Constructor with id excluded
    public DailySchedule(String name, String header, String description, LocalDateTime startTime, LocalDateTime endTime, Integer nextPlanDuration) {
        this.name = name;
        this.header = header;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.nextPlanDuration = nextPlanDuration;
    }
}
