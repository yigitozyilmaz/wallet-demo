package com.example.odev.webApiControllers;

import com.example.odev.Entity.DailySchedule;
import com.example.odev.business.requests.DailyScheduleRequest;
import com.example.odev.mappers.DailyScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/daily-schedules")
public class DailyScheduleController {

    @Autowired
    private DailyScheduleService dailyScheduleService;

    @PostMapping
    public ResponseEntity<DailySchedule> createDailySchedule(@RequestBody DailyScheduleRequest request) {
        DailySchedule dailySchedule = new DailySchedule(
                request.getName(),
                request.getHeader(),
                request.getDescription(),
                request.getStartTime(), // Date türünde
                request.getEndTime(), // Date türünde
                request.getNextPlanDuration()
        );
        DailySchedule createdSchedule = dailyScheduleService.createDailySchedule(dailySchedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DailySchedule>> getAllDailySchedules() {
        List<DailySchedule> dailySchedules = dailyScheduleService.getAllDailySchedules();
        return new ResponseEntity<>(dailySchedules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailySchedule> getDailyScheduleById(@PathVariable Long id) {
        return dailyScheduleService.getDailyScheduleById(id)
                .map(dailySchedule -> new ResponseEntity<>(dailySchedule, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDailySchedule(@PathVariable Long id) {
        dailyScheduleService.deleteDailySchedule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Object>> searchByName(@RequestParam String name) {
        List<DailySchedule> dailySchedules = dailyScheduleService.getDailySchedulesByName(name);

        List<Object> combinedResults = new ArrayList<>();
        combinedResults.addAll(dailySchedules);

        return ResponseEntity.ok(combinedResults);
    }
}
