package com.levelup.java.collections.list;

import java.util.List;

import org.junit.Test;

public class ImmutableListJava9 {

    @Test
    public void immutableListFactory() {
        List<String> stringList = List.of("one", "two", "three");
        System.out.println(stringList);
    }

    @Test
    public void immutableListFromArray() {
        String[] legendsDivision = {
                "Michigan",
                "Michigan State",
                "Minnesota",
                "Northwestern",
                "Iowa",
                "Nebraska"
        };

        List<String> stringSet = List.of(legendsDivision);
        System.out.println(stringSet);
    }

}
