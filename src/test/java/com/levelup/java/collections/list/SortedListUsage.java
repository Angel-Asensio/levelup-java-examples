package com.levelup.java.collections.list;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

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

    class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public String toString() {
            return "(" + id + ", " + name + ")";
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

        SortedList personsByName = new SortedList(Comparator.comparing(Person::getName));
        personsByName.add(new Person(2, "Z"));
        personsByName.add(new Person(1, "X"));
        personsByName.add(new Person(4, "C"));
        personsByName.add(new Person(3, "A"));

        System.out.println("Persons bynName:");
        personsByName.forEach(System.out::println);
    }


}
