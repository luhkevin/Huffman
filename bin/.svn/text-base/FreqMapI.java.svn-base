import java.io.IOException;
import java.util.Set;

public interface FreqMapI {

	/**
	 * The frequency map class should be able to read the text from
	 * a text file and create a map of frequencies with each character
	 * as a key. Each frequency value should be an integer value.
	 *
	 * @param filename: name of the text file.
	 * @throws IOException if there are any issues in reading the input file.
	 */
	public void buildMap(String filename) throws IOException;
	
	/**
	 * Return the alphabet of the text specified - all the characters 
	 * in the input text.
	 * 
	 * @return: a set of characters
	 */
	public Set<Character> getAlphabet();

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
	public int getFrequency(char c) throws InvalidCharException;


}
