package com.andrepimenta.exemplo.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class BirthDayService {

	/**
	 * Returns de Age from Birth Date
	 * 
	 * @param birthDate
	 * @return
	 */
	public Integer verifyAgeWithBirthIn(Date birthDate) {

		LocalDate now = LocalDate.now();
		LocalDate birth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		return Period.between(birth, now).getYears();
	}

}
