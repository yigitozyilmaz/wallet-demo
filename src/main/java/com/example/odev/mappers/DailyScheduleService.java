package com.example.odev.mappers;

import com.example.odev.Entity.DailySchedule;
import com.example.odev.Repository.DailyScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyScheduleService {

    @Autowired
    private DailyScheduleRepository dailyScheduleRepository;

    public DailySchedule createDailySchedule(DailySchedule dailySchedule) {
        return dailyScheduleRepository.save(dailySchedule);
    }

    public List<DailySchedule> getAllDailySchedules() {
        return dailyScheduleRepository.findAll();
    }

    public Optional<DailySchedule> getDailyScheduleById(Long id) {
        return dailyScheduleRepository.findById(id);
    }

    public void deleteDailySchedule(Long id) {
        dailyScheduleRepository.deleteById(id);
    }

    public List<DailySchedule> getDailySchedulesByName(String name) {
        return dailyScheduleRepository.findByName(name);
    }
}
