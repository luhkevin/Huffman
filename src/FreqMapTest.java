import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class FreqMapTest {
	private FreqMap fm = null;

	@Before
	public void setUp() throws Exception {
		fm = new FreqMap();
	}

	@Test
	public void testFreqMap() {
		assertFalse(fm == null);
	}

	@Test
	public void testBuildMap() {
		try {
			fm.buildMap("test.txt");
			try {
				fm.buildMap("nonexisant.txt");
				fail();
			} catch(IOException e){
				assertTrue(true);
			}
		}
		catch (IOException e){
			fail();
		}
	}
	
	@Test
	public void testGetAlphabet() {
		try {
			fm.buildMap("test.txt");
		} catch (IOException e) {
			fail();
		}
		assertEquals(42, fm.getAlphabet().size());
	}

	@Test
	public void testGetFrequency() {
		try {
			fm.buildMap("test.txt");
		} catch (IOException e1) {
			fail();
		}
		assertEquals(128, fm.getFrequency('e'));
		assertEquals(14, fm.getFrequency('w'));
		assertEquals(9, fm.getFrequency('0'));
		
		try {
			assertEquals(0, fm.getFrequency('j'));
			fail();
		}
		catch(InvalidCharException e){
			assertTrue(true);
		}
		

		try {
			fm.buildMap("test2.txt");
		} catch (IOException e1) {
			fail();
		}
		assertEquals(3, fm.getFrequency('t'));
		assertEquals(3, fm.getFrequency(' '));
		assertEquals(1, fm.getFrequency('.'));
		
		try {
			fm.buildMap("test3.txt");
		} catch (IOException e1) {
			fail();
		}
		assertEquals(6, fm.getFrequency('d'));
		assertEquals(4, fm.getFrequency('c'));
		assertEquals(3, fm.getFrequency('b'));
		assertEquals(2, fm.getFrequency('a'));		
		
		try {
			fm.buildMap("test4.txt");
		} catch (IOException e1) {
			fail();
		}
		assertEquals(6, fm.getFrequency('d'));
		assertEquals(4, fm.getFrequency('c'));
		assertEquals(3, fm.getFrequency('b'));
		assertEquals(2, fm.getFrequency('a'));		
		
		try {
			assertEquals(0, fm.getFrequency('A'));
			fail();
		}
		catch(InvalidCharException e){
			assertTrue(true);
		}
		
		try {
			fm.buildMap("test5.txt");
		} catch (IOException e1) {
			fail();
		}
		assertEquals(4, fm.getFrequency('d'));
		assertEquals(2, fm.getFrequency('c'));
		assertEquals(2, fm.getFrequency('b'));
		assertEquals(2, fm.getFrequency('a'));	
		assertEquals(4, fm.getFrequency('"'));	
		assertEquals(1, fm.getFrequency('.'));	
	}	
	
}
	


