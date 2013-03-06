import java.util.NoSuchElementException;

/**
 * A binary heap, with the minimum at the root.
 * @param <K> A comparable element stored by this heap.
 * @author CIS-121 Staff
 * @version 2.0 - 10/16/12
 */
public interface BinaryMinHeapI<K extends Comparable<? super K>>
{
	/**
	 * Returns the "underlying array" to the binary min heap. Normally you 
	 * would not return this, but we are asking you to implement this method
	 * for the purposes of our testing.
	 * @return
	 */
	public K[] getUnderlyingArray();
	
	/**
	 * Returns true if this heap is empty.
	 * @return True if this heap is empty.
	 */
    public boolean isEmpty();
    
    /**
     * Removes the minimum key in this heap, and returns it.
     * @return The minimum key in this heap.
     * @throws NoSuchElementException If the heap is empty.
     */
    public K removeMin() throws NoSuchElementException;
    
    /**
     * Insert the given key into the heap.
     * @param k The key to insert.
     */
    public void insert(K k);
}
