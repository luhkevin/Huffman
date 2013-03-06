import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BinaryMinHeapTest {

	BinaryMinHeap<Integer> testheap;
	BinaryMinHeap<Integer> testheap2;
	BinaryMinHeap<Integer> testheap3;
	BinaryMinHeap<Integer> testheap4;

			
	@Before
	public void setUp() throws Exception {
		testheap = new BinaryMinHeap<Integer>(Integer.class);
		testheap2 = new BinaryMinHeap<Integer>(Integer.class);
		testheap3 = new BinaryMinHeap<Integer>(Integer.class);
		testheap4 = new BinaryMinHeap<Integer>(Integer.class);
	}

	@Test
	public void testGetUnderlyingArray() {
		testheap.insert(3);
		Integer[] expected = new Integer[127];
		expected[1] = new Integer(3);
		assertArrayEquals(expected, testheap.getUnderlyingArray());
	}

	@Test
	public void testIsEmpty() {
		testheap.insert(7);
		assertFalse(testheap.isEmpty());
		testheap.removeMin();
		assertTrue(testheap.isEmpty());
	}

	@Test
	public void testRemoveMin() {
		testheap.insert(8);
		testheap.insert(3);
		assertEquals(new Integer(3), testheap.removeMin());
	}
	
	@Test
	public void testMultipleRemoveMin() {
		testheap2.insert(8);
		testheap2.insert(3);
		testheap2.insert(7);
		testheap2.insert(2);
		testheap2.insert(11);
			
		assertEquals(new Integer(2), testheap2.removeMin());
		assertEquals(new Integer(3), testheap2.removeMin());
		assertEquals(new Integer(7), testheap2.removeMin());
		assertEquals(new Integer(8), testheap2.removeMin());
		assertEquals(new Integer(11), testheap2.removeMin());
				
	}
	
	@Test
	public void testInsertCopiesNegative() {
		testheap3.insert(-8);
		testheap3.insert(-5);
		testheap3.insert(-8);
		testheap3.insert(-7);
		testheap3.insert(-3);
		testheap3.insert(-5);

		assertEquals(new Integer(-8), testheap3.removeMin());
		assertEquals(new Integer(-7), testheap3.removeMin());
		assertEquals(new Integer(-5), testheap3.removeMin());
		assertEquals(new Integer(-3), testheap3.removeMin());
		assertTrue(testheap3.isEmpty());
	}

	@Test
	public void testgetArrays() {
		testheap4.insert(-5);
		testheap4.insert(1);
		testheap4.insert(6);
		testheap4.insert(-2);
		testheap4.insert(3);
		testheap4.insert(4);
		assertEquals(testheap4.getUnderlyingArray()[1].toString(), "-5");
		assertEquals(testheap4.getUnderlyingArray()[6].toString(), "6");


	}

}
