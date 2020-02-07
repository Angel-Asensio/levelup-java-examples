package com.levelup.java.date.conversion;

import java.time.LocalDate;
import java.util.Date;

public class JavaSqlDateToLocalDate {

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

}
