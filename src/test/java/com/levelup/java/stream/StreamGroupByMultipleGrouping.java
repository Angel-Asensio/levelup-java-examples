package com.levelup.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.Value;

public class StreamGroupByMultipleGrouping {

    public enum Country { POLAND, UK, GERMANY }

    @Value
    class Student {
        private final String name;
        private final int age;
        private final Country country;
        private final int score;
    }

    @Test
    public void groupByCountryThenByAge() {
        List<Student> students = Arrays.asList(
                /*           NAME             AGE     COUNTRY           SCORE       */
                new Student("Jan",     13, Country.POLAND,  92),
                new Student("Anna",    15, Country.POLAND,  95),
                new Student("Helga",   14, Country.GERMANY, 93),
                new Student("Leon",    14, Country.GERMANY, 97),
                new Student("Michael", 14, Country.UK,      90),
                new Student("Tim",     15, Country.UK,      91),
                new Student("George",  14, Country.UK,      98)
        );

        Map<Country, Map<Integer, List<Student>>> studentsByCountryByAge = students.stream()
                        .collect(Collectors.groupingBy(Student::getCountry, Collectors.groupingBy(Student::getAge)));

        System.out.println(studentsByCountryByAge);
    }

}
