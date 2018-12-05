package com.free_calendar_system.calendar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "paisV")
public class Pais extends CodeDescriptionAbstract {
	@Override
	public boolean isPais()
	{
		return true;
	}
}
