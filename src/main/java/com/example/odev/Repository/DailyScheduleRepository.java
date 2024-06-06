package com.example.odev.Repository;

import com.example.odev.Entity.DailySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyScheduleRepository extends JpaRepository<DailySchedule, Long> {
    List<DailySchedule> findByName(String name);
}
