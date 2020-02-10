package com.levelup.java.collections.map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MutableMapJava9 {

    @Test
    public void createMutableMapJava9() {
        Map<String, String> map = new HashMap<>(Map.of("Red", "#FF0000", "Blue", "#0000FF"));
        System.out.println(map);
    }
}
