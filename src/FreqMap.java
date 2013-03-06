import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FreqMap implements FreqMapI {

	/**
	 * The frequency map class should be able to read the text from
	 * a text file and create a map of frequencies with each character
	 * as a key. Each frequency value should be an integer value.
	 *
	 * @param filename: name of the text file.
	 * @throws IOException if there are any issues in reading the input file.
	 */
	private Map<Character, Integer> fMap = new HashMap<Character, Integer>(); 
	
	public FreqMap(){ } 
	
	public void buildMap(String filename) throws IOException {
		// TODO Auto-generated method stub
		if(filename == null){
			throw new IOException();
		}

		fMap.clear();

		BufferedReader r = new BufferedReader(new FileReader(filename));

		char[] tokenArr;
		String line = r.readLine();
		while(line != null){		
			tokenArr = line.toCharArray();
			for(char elt : tokenArr){
				elt = Character.toLowerCase(elt);
				if(fMap.containsKey(elt)){
					fMap.put(elt, new Integer(fMap.get(elt) + 1));
				} else {
					fMap.put(elt, 1);
				}
			}
			line = r.readLine();
		}
		r.close();
	}
	
	/**
	 * Return the alphabet of the text specified - all the characters 
	 * in the input text.
	 * 
	 * @return: a set of characters
	 */
	public Set<Character> getAlphabet() {
		// TODO Auto-generated method stub
		return fMap.keySet();
	}

	/**
	 * Returns the numerical value for the frequency of the requested
	 * character.
	 *
	 * @param c: the character that we look for
	 * @return: the frequency of the character if the character is in the
	 * frequency map - the number of times that character appeared in the 
	 * input text.
	 * @throws InvalidCharException if the character is not present
	 * in the frequency map (in the alphabet).
	 */
	public int getFrequency(char c) throws InvalidCharException {		
		if(!fMap.containsKey(c)){
			throw new InvalidCharException();
		}
		
		return fMap.get(c);
	}

}
