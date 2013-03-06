import java.lang.reflect.Array;
import java.util.NoSuchElementException;


public class BinaryMinHeap<K extends Comparable<? super K>> 
		implements BinaryMinHeapI<K>{

	K[] arr;
	
	public BinaryMinHeap(Class<K> type){ 
		arr = (K[]) Array.newInstance(type, 127);
	}
	
	@Override
	public K[] getUnderlyingArray() {
		// TODO THROW EXCEPTIONS
		return arr;
	}
	
	@Override
	public boolean isEmpty() {		
		return (arr[1] == null);
	}

	@Override
	public K removeMin() throws NoSuchElementException {
		int last = find();
		if(arr[1] == null){
			throw new NoSuchElementException();
		}
		
		K temp = arr[1];
		arr[1] = arr[last];
		arr[last] = null;
		sink(1);
		

		
		return temp;
	}
	
	@Override
	public void insert(K k) {
		if(!foundCopy(k)){ 
			int last = find();
			arr[last + 1] = k;
			swim(last + 1);
		}
	}
	
	//Finds the array key with the last element of the heap
	private int find(){
		for(int i = 1; i < arr.length; i++){
			if(arr[i] == null){
				return i - 1;
			}
		}
		return 0;
	}
	
	//Swim and sink fix heap order violations 
	//(if node key is larger/smaller than one of children's keys
	private void swim(int k){						
		while(k > 1 && greater(k/2, k)){
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k){
		int len = find();
		while (2*k <= len){
			int j = 2*k;
			if (j < len && greater(j, j + 1)) j++;
			if (!greater(k, j)) break;
			exch(k, j);
			k = j;	
		}
	}
	
	//Compares keys...greater or equal
	private boolean greater(int i, int j){
		return arr[i].compareTo(arr[j]) > 0;
	}
	
		
	//Exchanges key positions
	private void exch(int i, int j){
		K t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	//Checks if there's another instance of k in the heap.
	private boolean foundCopy(K k){
		for(K elt : arr){			
			if(elt == k){
				return true;
			}
		}
		return false;
	}
}
