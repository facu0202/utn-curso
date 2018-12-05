package com.free_calendar_system.calendar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "localidadV")
public class Localidad extends CodeDescriptionAbstract  {
	@Override
	public boolean isLocalidad()
	{
		return true;
	}
	
}
