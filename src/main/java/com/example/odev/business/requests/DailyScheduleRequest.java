package com.example.odev.business.requests;

import lombok.Data;

import java.util.Date;

@Data
public class DailyScheduleRequest {
    private String name;
    private String header;
    private String description;
    private Date startTime; // String olarak alınacak
    private Date endTime; // String olarak alınacak
    private Integer nextPlanDuration;
}
