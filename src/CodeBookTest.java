import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CodeBookTest {
	CodeBook testBook;
	CodeBook testBook2;
	
	@Before
	public void setUp() throws Exception {
		HashMap<Character, String> testMap = new HashMap<Character, String>();
		HashMap<Character, String> testMap2 = new HashMap<Character, String>();
		/*
		 * This would be a valid huffman map if your input text has freqs of:
		 * a - 12, b - 4, c - 6, d - 8.
		 */
		testMap.put('a', "0");
		testMap.put('d', "10");
		testMap.put('c', "111");
		testMap.put('b', "110");
		testBook = new CodeBook(testMap);
		
		/*
		 * Valid huffman map for input text with freqs of:
		 * a - 2, b - 2, c - 4, d - 10
		 */
		testMap2.put('d', "0");
		testMap2.put('c', "10");
		testMap2.put('a', "110");
		testMap2.put('b', "111");
		testBook2 = new CodeBook(testMap2);		
	}

	@After
	public void tearDown() throws Exception {
		testBook = null;
	}

	@Test
	public void testGetCodeChar() {
		assertEquals("0", testBook.getCode('a'));
		assertEquals("110", testBook.getCode('b'));
		assertEquals("111", testBook.getCode('c'));
		assertEquals("10", testBook.getCode('d'));
	}

	@Test
	public void testGetCodeString() {
		assertEquals("00111110", testBook.getCode("aacb"));
	}

	@Test
	public void testDecode() {
		assertEquals("aacb", testBook.decode("00111110"));
		assertEquals("bbbb", testBook.decode("110110110110"));

		assertEquals("d", testBook.decode("10"));
		assertEquals("b", testBook.decode("110"));
		assertEquals("a", testBook.decode("0"));
		assertEquals("c", testBook.decode("111"));
		assertEquals("ac", testBook.decode("0111"));

		
		assertEquals("d", testBook2.decode("0"));
		assertEquals("c", testBook2.decode("10"));
		assertEquals("b", testBook2.decode("111"));
		assertEquals("a", testBook2.decode("110"));
	}
	
	@Test
	public void testInvalidSymbol() {
		try{
			assertEquals("not binary", testBook.decode("001111120"));
			assertEquals("not binary", testBook.decode("24560"));
			fail();
		}
		catch (InvalidSymbolException e) { 
			assertTrue(true);
		}
	}
	
	
	@Test
	public void testIllegalArgument() {
		try{
			assertEquals("not in codebook", testBook.decode("1111"));
			assertEquals("not in codebook", testBook.decode("0101"));
			assertEquals("not in codebook", testBook.decode("010100101"));
			fail();
		}
		catch (IllegalArgumentException e) { 
			assertTrue(true);
		}
	}

}
