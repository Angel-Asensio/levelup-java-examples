package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * This java example will demonstrate printing an array and multidimensional array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/print-array/'>Print array</a>
 * 
 */
public class PrintArray {
	
	@Test
	public void print_array_in_java () {
		String[] legendsDivision = {
				"Michigan", "Michigan State", "Minnesota", 
				"Northwestern", "Iowa", "Nebraska"};
		
		assertEquals("[Michigan, Michigan State, "
				+ "Minnesota, Northwestern, Iowa, Nebraska]", 
				Arrays.toString(legendsDivision));

	}
	
	@Test
	public void print_multidimensional_array_in_java () {
		String[][] big10Conference = {
				{"Michigan", "Michigan State", "Minnesota", "Northwestern", "Iowa", "Nebraska"},
				{"Ohio State", "Illinois", "Indiana", "Penn State", "Wisconsin", "Purdue"}
			   };
		
		assertEquals ("[[Michigan, Michigan State, Minnesota, Northwestern, Iowa, Nebraska], "
				+ "[Ohio State, Illinois, Indiana, Penn State, Wisconsin, Purdue]]", 
				Arrays.deepToString(big10Conference));
		
	}

	public <E> void printArray(final E[] inputArray ) {
		// Display array elements
		for(E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();

	}
	
	@Test
	public void printIntegerArray() {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		printArray(intArray);
	}

	@Test
	public void printCharacterArray() {
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		printArray(charArray);
	}
	
		
}
