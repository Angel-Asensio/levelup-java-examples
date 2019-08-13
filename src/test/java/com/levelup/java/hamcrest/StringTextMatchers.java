package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace;
import static org.hamcrest.text.StringContainsInOrder.stringContainsInOrder;
import static org.junit.Assert.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate testing
 * strings with junit and hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/hamcrest-text-matchers-junit-testing/'>Text matchers</a>
 * 
 */
public class StringTextMatchers {

	@Test
	public void string_is_empty () {

		String favoriteCereal = "";
		assertThat(favoriteCereal, isEmptyString());
	}
	
	@Test
	public void string_is_empty_or_null () {
		String favoriteCereal = null;
		assertThat(favoriteCereal, isEmptyOrNullString());
	}

	@Test
	public void string_equal_to () {

		String favoriteCereal = "cinnamon life";
		assertThat(favoriteCereal, equalTo("cinnamon life"));
	}

	@Test
	public void string_equal_to_ignoring_case () {

		String favoriteCereal = "CINNAMON LIFE";
		assertThat(favoriteCereal, equalToIgnoringCase("cinnamon life"));
	}
	
	@Test
	public void string_equal_to_ignoring_whitespace () {

		String favoriteCereal = "CINNAMON LIFE          ";
		assertThat(favoriteCereal, equalToIgnoringWhiteSpace("cinnamon life"));
	}
	
	@Test
	public void string_contains () {
		
		String cereal = "mini wheats";
		assertThat(cereal, containsString("mini"));
	}

	@Test
	public void string_starts_with () {

		String cereal = "honey smacks";
		assertThat(cereal, startsWith("honey"));
	}

	@Test
	public void string_ends_with () {

		String cereal = "corn flakes";
		assertThat(cereal, endsWith("s"));
	}

	@Test
	public void string_has_order () {
		
		String cereal = "apple jacks";
		assertThat(cereal, stringContainsInOrder(Lists.newArrayList("apple", "jacks")));
	}

	
}
