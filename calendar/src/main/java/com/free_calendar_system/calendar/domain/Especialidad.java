package com.free_calendar_system.calendar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue (value = "especialidadV")
public class Especialidad extends CodeDescriptionAbstract {

}
