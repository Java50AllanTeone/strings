package telran.text;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringTests {
	private static final int N_STRINGS = 10000;
	private static final int N_RUNS = 1000;
	String[] strings = {"12", "34", "56"};
	String delimiter = "&";
	String expected = "12&34&56";
	
	@BeforeEach
	void setUp() {
		
	}

	@Disabled
	@Test
	void test() {
//		String str = new String("Hello");
//		str += " World";
//		assertTrue(str == "Hello World");
		
//		String str1 = "lmn";
//		updateString(str1);
//		assertEquals(str1, "lmnabc");
		
		StringBuilder str2 = new StringBuilder("lmn");
		updateString(str2);
		assertEquals(str2.toString(), "lmnabc");
	}
	
	@Test
	void joinStringsTest() {
		assertEquals(expected, joinStrings(strings, delimiter));
	}
	
	@Test
	void joinStringsinBuilderTest() {
		assertEquals(expected, joinStringsInBuilder(strings, delimiter));
	}
	
	@Test
	void joinStringsPerformanceTest() {
		String[] array = getBigArray();
		
		for (int i = 0; i < N_RUNS; i++) {
			joinStrings(array, " ");
		}
	}
	
	@Test
	void joinStringsInBuilderPerformanceTest() {
		String[] array = getBigArray();
		
		for (int i = 0; i < N_RUNS; i++) {
			joinStringsInBuilder(array, " ");
		}
	}
	
	
	private String[] getBigArray() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res, "hello");
		return res;
	}

	private void updateString(String str) {
		str += "abc";
	}
	
	
	private void updateString(StringBuilder builder) {
		builder.append("abc");
	}
	
	
	private String joinStrings(String[] strings, String delimiter) {
		String res = "";
		
		if (strings != null && strings.length > 0) {
			res = strings[0];
			
			for (int i = 1; i < strings.length; i++) {
				res += delimiter + strings[i];
			}
		}
		return res;
	}
	
	
	private String joinStringsInBuilder(String[] strings, String delimiter) {
		String res = "";
		
		if (strings != null && strings.length > 0) {
			StringBuilder builder = new StringBuilder(strings[0]);
			
			for (int i = 1; i < strings.length; i++) {
				builder.append(delimiter + strings[i]);
			}
			res = builder.toString();
		}
		return res;
	}

}
