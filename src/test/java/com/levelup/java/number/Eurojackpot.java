package com.levelup.java.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class Eurojackpot {

    private static final String PATTERN = "###,###.###";
    private static final Locale SPANISH = new Locale("es", "ES");
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(SPANISH);
    private static final DecimalFormat DECIMAL_FORMAT = (DecimalFormat) NUMBER_FORMAT;

    public long binomial(int n, int k) {
        long result = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }


    @Test
    public void lotto6aus49Gewinnchance() {
        long sequences = binomial(49, 6) * 10;
        System.out.printf("lotto 6 aus 49 Gewinnchance: 1 : %s%n", format(sequences));
    }

    private String format(long input) {
        DECIMAL_FORMAT.applyPattern(PATTERN);
        return DECIMAL_FORMAT.format(input);
    }

    /**
     * Welche Gewinnklasse ein Spiel erreicht, ergibt sich aus der Kombination der Anzahl an Richtigen in Feld A (aus 50 Zahlen werden 5 getippt
     * und 5 gezogen) und Feld B (aus 10 Eurozahlen werden 2 getippt und 2 gezogen)
     */
    @Test
    public void eurojackpotGewinnchance() {
        long sequences = binomial(50, 5) * binomial(10, 2);
        System.out.printf("eurojackpot Gewinnchance: 1 : %s%n", format(sequences));
    }

    @Test
    public void eurojackpotGeneratorWithSelectedNumbers() {
        Integer[] selected = { 12, 16, 18, 20, 23, 32, 35, 42, 44, 47 };

        Set<Integer> numbers = new TreeSet<>();

        while (numbers.size() < 5) {
            int chosen = selected[getRandomIndex()];
            if (!numbers.contains(chosen)) {
                numbers.add(chosen);
            }
        }

        Set<Integer> stars = ImmutableSet.of(5, 8);
        System.out.printf("eurojackpot: %s + %s%n", numbers, stars);
    }

    @Test
    public void eurojackpotGenerator() {

        Set<Integer> fieldA = new TreeSet<>();

        while (fieldA.size() < 5) {
            int chosen = getRandomValidNumber(50);
            if (!fieldA.contains(chosen)) {
                fieldA.add(chosen);
            }
        }

        Set<Integer> fieldB = new TreeSet<>();

        while (fieldB.size() < 2) {
            int chosen = getRandomValidNumber(10);
            if (!fieldB.contains(chosen)) {
                fieldB.add(chosen);
            }
        }

        System.out.printf("eurojackpot: %s + %s%n", fieldA, fieldB);
    }


    int getRandomIndex() {
        return ThreadLocalRandom.current().nextInt(10);
    }

    int getRandomValidNumber(final int bound) {
        return ThreadLocalRandom.current().nextInt(bound) + 1;
    }

    @Test
    public void lotto6aus49Generator() {
        Set<Integer> numbers = new TreeSet<>();

        while (numbers.size() < 6) {
            int chosen = getRandomValidNumber(49);
            if (!numbers.contains(chosen)) {
                numbers.add(chosen);
            }
        }

        System.out.printf("6 aus 49: %s%n", numbers);
    }

}

