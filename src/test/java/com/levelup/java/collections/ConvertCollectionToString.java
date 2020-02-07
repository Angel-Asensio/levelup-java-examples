package com.levelup.java.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ConvertCollectionToString {

    public <E> String toStringFromCollectionAsStream(Collection<E> collection){
        String result = collection.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));

        return result;
    }


    @Test
    public void convertToString() {
        List<String> names = Arrays.asList("xenia", "peter", "anna", "mike");
        System.out.println(toStringFromCollectionAsStream(names));
    }
}
