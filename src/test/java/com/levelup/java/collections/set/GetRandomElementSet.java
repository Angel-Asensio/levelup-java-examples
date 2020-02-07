package com.levelup.java.collections.set;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class GetRandomElementSet {

    private static final Set<Integer> ODD_NUMBERS_UNDER_TEN =
            ImmutableSet.<Integer>builder()
                    .add(1)
                    .add(3)
                    .add(5)
                    .add(7)
                    .build();

    private static <E> E getRandomElementFromSet(final Set<E> inputSet) {
        return inputSet.stream()
                .skip(ThreadLocalRandom.current().nextInt(inputSet.size()))
                .findFirst()
                .orElse(null);
    }

    @Test
    public void getRandomOddNumberFromSet() {
        final Integer randomElementFromSet = getRandomElementFromSet(ODD_NUMBERS_UNDER_TEN);
        System.out.println(randomElementFromSet);
    }

}
