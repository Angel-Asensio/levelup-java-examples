package com.levelup.java.collections.map;

import static java.util.Map.entry;

import java.util.Map;

import org.junit.Test;

public class ImmutableMapJava9 {

    @Test
    public void immutableMapFactory() {
        Map<String, Integer> immutableMap = Map.of("One", 1, "Two", 2, "Three", 3);
        System.out.println(immutableMap);
    }

    @Test
    public void immutableMapFromArray() {
        Map.Entry<String, Integer>[] entries = new Map.Entry[] {
                entry("One", 1),
                entry("Two", 2),
                entry("Three", 3)
        };

        Map<String, Integer> immutableMap = Map.ofEntries(entries);
        System.out.println(immutableMap);
    }
}
