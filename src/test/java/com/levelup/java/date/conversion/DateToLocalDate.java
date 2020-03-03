package com.levelup.java.date.conversion;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class DateToLocalDate {

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public LocalDate convertToLocalDateViaMilliseconds(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public LocalDate convertToLocalDateJava9(Date dateToConvert) {
        return LocalDate.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    Comparator<LocalDate> descendingLocalDate = (x, y) -> {
        if (x.isAfter(y)) {
            return -1;
        } else if (x.isEqual(y)) {
            return 0;
        } else {
            return 1;
        }
    };

    @Test
    public void dateToLocalDateViaInstant() {
        Calendar newYearsDay = Calendar.getInstance();
        newYearsDay.set(2013, 0, 1, 0, 0, 0);

        Calendar newYearsEve = Calendar.getInstance();
        newYearsEve.setTimeInMillis(newYearsDay.getTimeInMillis());
        newYearsEve.add(Calendar.SECOND, -60);

        final LocalDate newYearsDayLocalDate = convertToLocalDateViaInstant(newYearsDay.getTime());
        final LocalDate newYearsEveLocalDate = convertToLocalDateViaInstant(newYearsEve.getTime());

        final List<LocalDate> result = Stream.of(newYearsEveLocalDate, newYearsDayLocalDate)
                .sorted(descendingLocalDate)
                .collect(Collectors.toList());

        System.out.println(result);
    }

}
