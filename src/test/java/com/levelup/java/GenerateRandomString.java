package com.levelup.java;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class GenerateRandomString {

	@Test
	public void random_string_apache() {
        final String output = RandomStringUtils.randomAlphanumeric(20);
        System.out.println(output);
    }
}
