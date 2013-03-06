import java.util.Set;

/**
 * A <code>CodeBookI</code> contains a hashmap of characters to their 
 * respective Huffman code, given .
 * It is also able to encode string using that hashmap.
 * It can also decode the bit sequence into the original string. 
 * @author CIS-121 Staff
 * @version 3.0 - 10/13/12
 */
public interface CodeBookI
{
	/**
	 * Get code of a single character.
	 * @param symbol The symbol for which you want to know the encoding
	 * @return The encoded string for that symbol
	 * @throws InvalidSymbolException If the given symbol is not handled by this
	 *             CodeBookI
	 */
	public String getCode(char symbol) throws InvalidSymbolException;

	/**
	 * Encodes a String of symbols.
	 * @param text The String to encode.
	 * @return The encoded text.
	 * @throws InvalidSymbolException If any symbol in text is not handled by 
	 * this CodeBook
	 */
	public String getCode(String text) throws InvalidSymbolException;
	
	/**
	 * Calculates the length of the encoding of a particular input text.
	 * @param text
	 * @return length of text
	 * @throws InvalidSymbolException If any symbol in text is not handled by 
	 * this CodeBook
	 */
	public int getCodingLength(String text) throws InvalidSymbolException;
	
	/**
	 * Decodes the given string bit-sequence.
	 * @param codedString The text to decode.
	 * @return The decoded text.
	 * @throws InvalidSymbolException If the input is not a valid bit-sequence
	 *             Contains something other that '0' or '1'.
	 * @throws IllegalArgumentException If the input contains an encoding not
	 *             recognized by the decoder.
	 */
	public String decode(String codedString) throws InvalidSymbolException, 
		IllegalArgumentException;
	
}