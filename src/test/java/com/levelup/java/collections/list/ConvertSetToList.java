package com.levelup.java.collections.list;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ConvertSetToList {

    @Test
    public void convert_set_to_list_with_java() {
        Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
        List<Integer> targetList = new ArrayList<>(sourceSet);
        assertThat(6, is(equalTo(targetList.size())));
    }

    @Test
    public void convert_set_to_list_with_guava() {
        Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
        List<Integer> targetList = Lists.newArrayList(sourceSet);
        assertThat(6, is(equalTo(targetList.size())));
    }

    @Test
    public void convert_set_to_list_with_commons() {
        Set<Integer> sourceSet = Sets.newHashSet(0, 1, 2, 3, 4, 5);
        List<Integer> targetList = new ArrayList<>(6);
        CollectionUtils.addAll(targetList, sourceSet.iterator());
        assertThat(6, is(equalTo(targetList.size())));
    }

}
