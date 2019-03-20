package com.levelup.java.hamcrest;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;

import com.google.common.collect.Lists;

public class IterableMatchers {

    @Test
    public void check_size_of_iterable () {

        List<String> cloths = Lists.newArrayList(
                "shirts", "shoes", "pants", "socks");

        assertThat(cloths, IsIterableWithSize.iterableWithSize(4));
    }

    @Test
    public void iterable_has_any_order () {

        List<String> cloths = Lists.newArrayList(
                "shirts", "shoes", "pants", "socks");

        assertThat(cloths, IsIterableContainingInAnyOrder.containsInAnyOrder("shoes", "pants", "shirts", "socks"));

    }

    @Test
    public void iterable_matches_order () {

        List<String> cloths = Lists.newArrayList(
                "shirts", "shoes", "pants", "socks");

        assertThat(cloths, IsIterableContainingInOrder.contains("shirts", "shoes", "pants", "socks"));

    }
}
