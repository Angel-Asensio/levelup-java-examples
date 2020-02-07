package com.levelup.java.optional;

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class ConvertOptionalToStream {

    @Test
    public void optional_to_stream() {
        Stream<String> strOptionalStream = Optional.ofNullable("String value").stream();
        Stream<String> filteredStream = strOptionalStream.filter((str) -> str != null && str.startsWith("String"));
        assertEquals(1, filteredStream.count());
    }
}
