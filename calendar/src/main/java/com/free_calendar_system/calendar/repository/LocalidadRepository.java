package com.free_calendar_system.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.free_calendar_system.calendar.domain.Localidad;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {

	public Localidad findFirstByDescripcion(String descripcion);
}
