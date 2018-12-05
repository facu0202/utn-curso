package com.free_calendar_system.calendar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "provinciaV")
public class Provincia extends CodeDescriptionAbstract {
	@Override
	public boolean isProvincia()
	{
		return true;
	}
}
