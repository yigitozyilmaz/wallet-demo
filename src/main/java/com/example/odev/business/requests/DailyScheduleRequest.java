package com.example.odev.business.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DailyScheduleRequest {
    private String name;
    private String header;
    private String description;
    private LocalDateTime startTime; // LocalDateTime türünde olacak
    private LocalDateTime endTime; // LocalDateTime türünde olacak
    private Integer nextPlanDuration;
}
