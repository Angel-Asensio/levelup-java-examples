package com.levelup.java.hamcrest;

import static com.levelup.java.hamcrest.OptionalMatcher.emptyOptional;
import static com.levelup.java.hamcrest.OptionalMatcher.optionalWithValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class OptionalTests {

    @Test
    public void assertThatOptionalIsEmpty() {
        final Optional<Object> empty = Optional.empty();
        assertThat(empty, is(emptyOptional()));
    }

    @Test
    public void assertThatOptionalHasValue() {
        final Optional<Integer> optionalInteger = Optional.ofNullable(Integer.MAX_VALUE);
        assertThat(optionalInteger, CoreMatchers.is(optionalWithValue(notNullValue())));
    }

}
