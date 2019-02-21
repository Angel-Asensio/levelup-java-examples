package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class OptionalTests {

    @Test
    public void assertThatOptionalIsEmpty() {
        final Optional<Object> empty = Optional.empty();
        assertThat(empty, CoreMatchers.is(OptionalMatcher.emptyOptional()));
    }

    @Test
    public void assertThatOptionalHasValue() {
        final Optional<Integer> optionalInteger = Optional.ofNullable(Integer.MAX_VALUE);
        assertThat(optionalInteger, CoreMatchers.is(OptionalMatcher.optionalWithValue(notNullValue())));
    }

}
