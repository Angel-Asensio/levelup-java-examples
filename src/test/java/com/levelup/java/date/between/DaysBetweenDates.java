 package com.levelup.java.date.between;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of days between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-days-between-two-dates/'>Number of days between two dates</a>
 * 
 */
public class DaysBetweenDates {

	@Test
	public void days_between_two_dates_in_java_with_java8 () {
		
		LocalDate startDate = LocalDate.now().minusDays(1);
		LocalDate endDate = LocalDate.now();
		
		long days = Period.between(startDate, endDate).getDays();
		assertEquals(1, days);
		
		// or 
		
		long days2 = ChronoUnit.DAYS.between(startDate, endDate);
		assertEquals(1, days2);
	}
	
	
	@Test
	public void days_between_two_dates_in_java_with_joda () {
		
		// start day is 1 day in the past
		DateTime startDate = new DateTime().minusDays(1);
		DateTime endDate = new DateTime();
		
		Days d = Days.daysBetween(startDate, endDate);
		int days = d.getDays();
		
		assertEquals(1, days);
	}

	@Test
	public void all_days_between_two_dates() {
		TemporalAccessor toTemporalAccessor = ISO_DATE.parse("2019-04-18");

		LocalDate to = LocalDate.from(toTemporalAccessor);
		LocalDate from = to.minusDays(7);

		long numOfDaysBetween = ChronoUnit.DAYS.between(from, to);
		List<String> allDates = IntStream.iterate(0, i -> i + 1)
				.limit(numOfDaysBetween + 1)
				.mapToObj(i -> from.plusDays(i).toString())
				.collect(Collectors.toList());

		System.out.println(allDates);
	}

}
