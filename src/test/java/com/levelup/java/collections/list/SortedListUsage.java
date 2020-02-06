package com.levelup.java.collections.list;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SortedListUsage {

    @Test
    public void create_sorted_list_comparable() {

        List sortedNames = new SortedList(Comparator.comparing(String::toString));
        sortedNames.add("Java");
        sortedNames.add("SQL");
        sortedNames.add("HTML");
        sortedNames.add("CSS");

        System.out.println("Print names:");
        // Print the sorted set of names
        System.out.println(sortedNames);
    }

    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    class Person {

        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    public void create_sorted_list_comparator() {

        List<Person> personsById = new SortedList(Comparator.comparing(Person::getId));

        personsById.add(new Person(1, "X"));
        personsById.add(new Person(3, "A"));
        personsById.add(new Person(4, "C"));
        personsById.add(new Person(4, "S")); // A duplicate Person
        personsById.add(new Person(2, "Z"));

        System.out.println("Persons by id:");
        personsById.forEach(System.out::println);

        System.out.println();

        SortedList personsByName = new SortedList(Comparator.comparing(Person::getName));
        personsByName.add(new Person(2, "Z"));
        personsByName.add(new Person(1, "X"));
        personsByName.add(new Person(4, "C"));
        personsByName.add(new Person(3, "A"));

        System.out.println("Persons by name:");
        personsByName.forEach(System.out::println);
    }


}
