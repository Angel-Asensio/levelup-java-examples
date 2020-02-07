package com.levelup.java.collections.set;


import java.util.Set;

import org.junit.Test;

public class ImmutableSetJava9 {

    @Test
    public void immutableSetJava9Factory() {
        Set<String> stringSet = Set.of("key1", "key2", "key3");
        System.out.println(stringSet);
    }

    @Test
    public void immutableSetFromArray() {
        String[] legendsDivision = {
                "Michigan",
                "Michigan State",
                "Minnesota",
                "Northwestern",
                "Iowa",
                "Nebraska"
        };

        Set<String> stringSet = Set.of(legendsDivision);
        System.out.println(stringSet);
    }

}
