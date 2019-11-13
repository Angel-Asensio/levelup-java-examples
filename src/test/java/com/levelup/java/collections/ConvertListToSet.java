package com.levelup.java.collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ConvertListToSet {

    @Test
    public void convert_list_to_set_with_java() {
        List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
        Set<Integer> targetSet = new HashSet<>(sourceList);
        assertThat(6, is(equalTo(targetSet.size())));
    }

    @Test
    public void convert_list_to_set_with_guava() {
        List<Integer> sourceList = Lists.newArrayList(0, 1, 2, 3, 4, 5);
        Set<Integer> targetSet = Sets.newHashSet(sourceList);
        assertThat(6, is(equalTo(targetSet.size())));
    }

    @Test
    public void convert_list_to_set_with_commons() {
        List<Integer> sourceList = Lists.newArrayList(0, 1, 2, 3, 4, 5);
        Set<Integer> targetSet = new HashSet<>(6);
        CollectionUtils.addAll(targetSet, sourceList.iterator());
        assertThat(6, is(equalTo(targetSet.size())));
    }

}
