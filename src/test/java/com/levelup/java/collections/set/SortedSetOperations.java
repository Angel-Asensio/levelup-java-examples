package com.levelup.java.collections.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

/**
 *  A sorted set is a set with ordering on its elements.
 *
 * SortedSet interface represents a sorted set in Java Collection Framework.
 *
 * The elements in a SortedSet can be sorted in a natural order with Comparable interface or using a Comparator.
 *
 * A SortedSet must know how to sort its elements as they are added by checking two interfaces:
 *
 *  *   If its elements implement the Comparable interface, it will use the compareTo() method to sort items.
 *  We can call this as sorting in natural order.
 *
 *  *   We can pass a Comparator to do custom sorting.
 *
 * If a Comparator is specified, the Comparator is used for sorting and ignore the Comparable interface.
 *
 * The TreeSet class is an implementation for the SortedSet interface in the Collections Framework.
 */
public class SortedSetOperations {

    @Test
    public void create_sorted_set_comparable() {

        Set sortedNames = new TreeSet<String>();
        sortedNames.add("Java");
        sortedNames.add("SQL");
        sortedNames.add("HTML");
        sortedNames.add("CSS");

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
        public boolean equals(Object o) {
            if (!(o instanceof Person)) {
                return false;
            }

            // id must be the same for two Persons to be equal
            Person p = (Person) o;
            if (this.id == p.getId()) {
                return true;
            }

            return false;
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
    public void create_sorted_set_comparator() {
        Set<Person> personsById = new TreeSet<>(Comparator.comparing(Person::getId));

        personsById.add(new Person(1, "X"));
        personsById.add(new Person(2, "Z"));
        personsById.add(new Person(3, "A"));
        personsById.add(new Person(4, "C"));
        personsById.add(new Person(4, "S")); // A duplicate Person

        System.out.println("Persons by id:");
        personsById.forEach(System.out::println);

        Set<Person> personsByName = new TreeSet<>(Comparator.comparing(Person::getName));
        personsByName.add(new Person(1, "X"));
        personsByName.add(new Person(2, "Z"));
        personsByName.add(new Person(3, "A"));
        personsByName.add(new Person(4, "C"));

        System.out.println("Persons by  Name: ");
        personsByName.forEach(System.out::println);
    }

    @Test
    public void sorted_set_operations() {
        SortedSet<String> names = new TreeSet<>();
        names.add("HTML");
        names.add("Java");
        names.add("SQL");
        names.add("CSS");

        System.out.println("Sorted Set: " + names);
        System.out.println("First: " + names.first());
        System.out.println("Last: " + names.last());

        SortedSet<String> ssBeforeCSS = names.headSet("CSS");
        System.out.println("headSet: " + ssBeforeCSS);

        SortedSet<String> ssBetweenCSSAndHTML = names.subSet("CSS", "HTML");
        System.out.println("subSet: " + ssBetweenCSSAndHTML);

        SortedSet<String> ssCSSAndAfter = names.tailSet("CSS");
        System.out.println("tailSet: " + ssCSSAndAfter);
    }



}
