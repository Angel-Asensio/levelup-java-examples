package com.levelup.java.hamcrest;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class MapMatchers {

    @Test
    public void map_has_entry() {

        Map<String, String> breeds = Maps.newHashMap();
        breeds.put("labrador", "buzz");
        breeds.put("dachshund", "gypsy");
        breeds.put("boxer", "buddy");

        assertThat(breeds, hasEntry("labrador", "buzz"));
    }

    @Test
    public void map_has_key() {

        Map<String, String> breeds = Maps.newHashMap();
        breeds.put("labrador", "buzz");
        breeds.put("dachshund", "gypsy");
        breeds.put("boxer", "buddy");

        assertThat(breeds, hasKey("labrador"));
    }

    @Test
    public void map_has_hasValue() {

        Map<String, String> breeds = Maps.newHashMap();
        breeds.put("labrador", "buzz");
        breeds.put("dachshund", "gypsy");
        breeds.put("boxer", "buddy");

        assertThat(breeds, hasValue("gypsy"));
    }
}