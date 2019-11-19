package com.levelup.java.collections.list;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * This java example will demonstrate finding an element in lists 
 * with straight up java, java 8 lambda expression and google Guava.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/find-element-in-list/'>Find elements in List</a>
 * 
 */
public class FindElementsInList {

	
	@Test
	public void find_elements_in_list_with_java () {

		List <Integer> numbers = Lists.newArrayList(
				new Integer(1), 
				new Integer(2), 
				new Integer(3));

		Integer value = null;
		for (Integer number : numbers) {
			if (number == 3) {
				value = number;
			}
		}
		assertEquals(new Integer(3), value);
	}
	
	@Test
	public void find_elements_in_list_with_java8_lambda () {

		List <Integer> numbers = Lists.newArrayList(
				new Integer(1), 
				new Integer(2), 
				new Integer(3));

		Optional<Integer> value = numbers
				.stream()
				.filter(a -> a == 3)
				.findFirst();
				
		assertEquals(new Integer(3), value.get());
	}
	
	
	@Test
	public void find_elements_in_lists_with_guava () {

		List <Integer> numbers = Lists.newArrayList(
				new Integer(1), 
				new Integer(2), 
				new Integer(3));
		
		Integer value = Iterables.find(numbers, new Predicate<Integer> () {
			public boolean apply(Integer number) {
				return number == 3 ;
			}
		});

		assertEquals(new Integer(3), value);
	}
	
	@Test
	public void find_elements_in_list_with_apachecommons () {
		
		List <Integer> numbers = Lists.newArrayList(
				new Integer(1), 
				new Integer(2), 
				new Integer(3));
		
		Integer value = (Integer) CollectionUtils.find(numbers, new org.apache.commons.collections.Predicate() {
			public boolean evaluate(Object number) {
				return ((Integer)number).intValue() == 3 ;
			}
		});

		assertEquals(new Integer(3), value);
	}
	
}
