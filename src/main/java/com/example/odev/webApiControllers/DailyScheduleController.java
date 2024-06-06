package com.example.odev.webApiControllers;

import com.example.odev.Entity.DailySchedule;
import com.example.odev.business.requests.DailyScheduleRequest;
import com.example.odev.mappers.DailyScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-schedules")
public class DailyScheduleController {

    private final DailyScheduleService dailyScheduleService;

    public DailyScheduleController(DailyScheduleService dailyScheduleService) {
        this.dailyScheduleService = dailyScheduleService;
    }

    @PostMapping
    public ResponseEntity<DailySchedule> createDailySchedule(@RequestBody DailyScheduleRequest request) {
        DailySchedule dailySchedule = new DailySchedule(
                request.getName(),
                request.getHeader(),
                request.getDescription(),
                request.getStartTime(), // LocalDateTime türünde
                request.getEndTime(), // LocalDateTime türünde
                request.getNextPlanDuration()
        );
        DailySchedule createdSchedule = dailyScheduleService.saveDailySchedule(dailySchedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DailySchedule>> getAllDailySchedules() {
        List<DailySchedule> dailySchedules = dailyScheduleService.getAllDailySchedules();
        return ResponseEntity.ok(dailySchedules);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DailySchedule>> getDailySchedulesByName(@RequestParam String name) {
        List<DailySchedule> dailySchedules = dailyScheduleService.getDailySchedulesByName(name);
        return ResponseEntity.ok(dailySchedules);
    }
}
