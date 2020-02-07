package com.levelup.java.lang;

import static org.junit.Assert.assertTrue;

import java.security.SecureRandom;
import java.util.OptionalInt;
import java.util.Random;

import org.junit.Test;

/** 
 * This java example will demonstrate generating a random number with java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/generate-random-number/'>Generate random number</a>
 * 
 */
public class GenerateRandomNumber {
	
	@Test
	public void generate_random_number_with_java () {
		Random random = new Random();
		
		double randomNumber = random.nextInt(10);
		
		assertTrue(randomNumber <=10);
	}
	
	@Test
	public void generate_secure_random_number_with_java () {
		SecureRandom random = new SecureRandom();

		double randomNumber = random.nextInt(10);
		
		assertTrue(randomNumber <=10);
	}
	
	@Test
	public void generate_single_random_number () {

		int randomNumber = (int)(Math.random() * 10);

		assertTrue(randomNumber < 10);
	}
	
	@Test
	public void generate_random_number_java8 () {

		Random random = new Random(10);

		OptionalInt randomNumber = random.ints(0, 10).findFirst();
		
		assertTrue(randomNumber.getAsInt() < 10);
	}
	

}
