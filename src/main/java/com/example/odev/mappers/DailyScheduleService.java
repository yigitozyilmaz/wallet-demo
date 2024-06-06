package com.example.odev.mappers;

import com.example.odev.Entity.DailySchedule;
import com.example.odev.Repository.DailyScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyScheduleService {
    private final DailyScheduleRepository dailyScheduleRepository;

    public DailyScheduleService(DailyScheduleRepository dailyScheduleRepository) {
        this.dailyScheduleRepository = dailyScheduleRepository;
    }

    public DailySchedule saveDailySchedule(DailySchedule dailySchedule) {
        return dailyScheduleRepository.save(dailySchedule);
    }

    public List<DailySchedule> getAllDailySchedules() {
        return dailyScheduleRepository.findAll();
    }

    public List<DailySchedule> getDailySchedulesByName(String name) {
        return dailyScheduleRepository.findByName(name);
    }
}
