package com.levelup.java.util.stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import lombok.Getter;
import lombok.Setter;

public class StreamGroupByFilterByMultipleAttributes {

    @Getter
    @Setter
    class Manager {

        private String firstName;
        private String lastName;
        private String function;

        public Manager(final String firstName, final String lastName, final String function) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.function = function;
        }
    }

    private List<Manager> managers;


    @Before
    public void setUp() {

        managers = new ArrayList<>();
        managers.add(new Manager("Olaf", "Kleidon", "Geschäftsführer"));
        managers.add(new Manager("Olaf", "Kleidon", "Geschäftsführer"));
        managers.add(new Manager("Michael", "Rittinghaus", "Geschäftsführer"));

        managers.add(new Manager("Ingo", "Ax", "Prokurist"));

        managers.add(new Manager("Michael", "X", "Inhaber"));
        managers.add(new Manager("Michael", "Rittinghaus", "Inhaber"));

    }

    /**
     * Java 8 stream distinct by multiple fields
     *
     * Collect distinct objects from a stream where each object is distinct by
     * comparing multiple fields or properties in Java 8
     */
    private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
        final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

        return t -> {
            final List<?> keys = Arrays.stream(keyExtractors)
                    .map(ke -> ke.apply(t))
                    .collect(Collectors.toList());

            return seen.putIfAbsent(keys, Boolean.TRUE) == null;
        };
    }

    private <T> List<T> joinSets(final Set<T> firstSet, final Set<T> secondSet, final Set<T> thirdSet) {
        List<T> result = new ArrayList<>();
        result.addAll(firstSet);
        result.addAll(secondSet);
        result.addAll(thirdSet);
        return result;
    }

    @Test
    public void group_by_function_filterDistinctByKeys() {
        Map<String, List<Manager>> groupByFunction = managers.stream()
                .collect(Collectors.groupingBy(Manager::getFunction));

        // filter duplicates
        List<Manager> managingDirectors = groupByFunction.get("Geschäftsführer");
        Set<Manager> uniqueManagingDirectors = Collections.emptySet();
        if (!isEmpty(managingDirectors)) {
            uniqueManagingDirectors = managingDirectors.stream()
                    .filter(distinctByKeys(Manager::getFirstName, Manager::getLastName))
                    .collect(toSet());
        }

        List<Manager> authorizedSignatories = groupByFunction.get("Prokurist");
        Set<Manager> uniqueAuthorizedSignatories = Collections.emptySet();
        if (!isEmpty(authorizedSignatories)) {
            uniqueAuthorizedSignatories = authorizedSignatories.stream()
                    .filter(distinctByKeys(Manager::getFirstName, Manager::getLastName))
                    .collect(toSet());
        }

        List<Manager> owners = groupByFunction.get("Inhaber");
        Set<Manager> uniqueOwners = Collections.emptySet();
        if (!isEmpty(owners)) {
            uniqueOwners = owners.stream()
                    .filter(distinctByKeys(Manager::getFirstName, Manager::getLastName))
                    .collect(toSet());
        }

        // get owners that are not managingDirectors
        Set<Manager> finalUniqueManagingDirectors = uniqueManagingDirectors;
        Set<Manager> ownersNotDirectors = uniqueOwners.stream()
                .filter(owner -> finalUniqueManagingDirectors.stream()
                        .noneMatch(manager -> manager.getFirstName().equals(owner.firstName) && manager.getLastName().equals(owner.lastName)))
                .collect(toSet());

        List<Manager> results = joinSets(uniqueManagingDirectors, uniqueAuthorizedSignatories, ownersNotDirectors);

        assertEquals(4, results.size());
    }

}
