import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HuffmanBuilderTest {
	FreqMap testMap;
	FreqMap testMap2;
	FreqMap testMap3;
	FreqMap testMap4;

	@Before
	public void setUp() throws Exception {
		testMap = new FreqMap();
		testMap.buildMap("test2.txt");
		
		testMap2 = new FreqMap();
		testMap2.buildMap("test3.txt");
		
		testMap3 = new FreqMap();
		testMap3.buildMap("test4.txt");
		
		testMap4 = new FreqMap();
		testMap4.buildMap("test6.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildHuffmanCode() {
		CodeBookI testBook = HuffmanBuilder.buildHuffmanCode(testMap);
		assertEquals(43, testBook.getCodingLength("This is a test."));
				
		CodeBookI testBook2 = HuffmanBuilder.buildHuffmanCode(testMap2);
		assertEquals(3, testBook2.getCodingLength("dc"));
		assertEquals(6, testBook2.getCodingLength("ddcc"));
		
		assertEquals("10", testBook2.getCode("c"));
		assertEquals("110", testBook2.getCode("a"));
		assertEquals("0", testBook2.getCode("d"));
		assertEquals("111", testBook2.getCode("b"));
		
		//You need to add more tests here, including checking the accuracy of 
		//actual codings and decodings rather than just coding length
	}
	
	@Test
	public void testBuildHuffmanCodeSameFreqAndCheckDecode() {				
		CodeBookI testBook4 = HuffmanBuilder.buildHuffmanCode(testMap4);		
		assertEquals("000", testBook4.getCode("a"));
		assertEquals("1", testBook4.getCode("d"));
		assertEquals("001", testBook4.getCode("b"));
		assertEquals("01", testBook4.getCode("c"));

		assertEquals("d", testBook4.decode("1"));
		assertEquals("b", testBook4.decode("001"));
		assertEquals("c", testBook4.decode("01"));
		assertEquals("a", testBook4.decode("000"));
	}

}
