package com.free_calendar_system.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.free_calendar_system.calendar.domain.Especialidad;
import com.free_calendar_system.calendar.domain.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

}
