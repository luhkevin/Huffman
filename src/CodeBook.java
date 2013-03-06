import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A <code>CodeBook</code> contains a hashmap of characters to their 
 * respective Huffman code, given .
 * It is also able to encode string using that hashmap.
 * It can also decode the bit sequence into the original string. 
 * @author CIS-121 Staff
 * @version 3.0 - 10/13/12
 */

public class CodeBook implements CodeBookI {

	/**
	 * Constructor for CodeBook. This should be the constructor you use
	 * to access CodeBook - don't build other constructors.
	 * @param codingMap
	 */ 
	private HashMap <Character, String> codemap;
	public CodeBook(HashMap<Character, String> codingMap) { 
		codemap = codingMap;
	}
	
	/**
	 * Get code of a single character.
	 * @param symbol The character for which you want to know the encoding
	 * @return The encoded string for that symbol
	 * @throws InvalidSymbolException If the given symbol is not handled by this
	 *             CodeBook
	 */
	public String getCode(char symbol) throws InvalidSymbolException {	
		//TODO: THROW EXCEPTIONS
		if(!codemap.keySet().contains(symbol)){
			throw new InvalidSymbolException(); 
		}
		return codemap.get(symbol);
	}

	/**
	 * Encodes a String of symbols.
	 * @param text The String to encode.
	 * @return The encoded text.
	 * @throws InvalidSymbolException If any symbol in text is not handled by 
	 * this CodeBook
	 */
	public String getCode(String text) throws InvalidSymbolException {
		//TODO: THROW EXCEPTIONS; to lowercase
		char c;
		int len = text.length();
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < len; i++){
			c = Character.toLowerCase(text.charAt(i));
			if(!codemap.keySet().contains(c)){
				throw new InvalidSymbolException(); 
			}
			str.append(getCode(c));
		}
		return str.toString();
	}
	
	/**
	 * Calculates the length of the encoding of a particular input text.
	 * @param text
	 * @return length of text
	 * @throws InvalidSymbolException If any symbol in text is not handled by 
	 * this CodeBook
	 */
	public int getCodingLength(String text) throws InvalidSymbolException{
		return getCode(text).length();
	}
	
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
			IllegalArgumentException {
		Collection<String> valueSet = new HashSet<String>();
		valueSet = codemap.values();	
		
		StringBuffer decoded = new StringBuffer();
		StringBuffer codebuf = new StringBuffer();
		
		char[] codeArr = codedString.toCharArray();
		int len = codeArr.length;
		int codePos = 0;
		for(char elt : codeArr){
			if(elt != '0' && elt != '1'){
				throw new InvalidSymbolException();
			}
			
			if(valueSet.contains(elt + "") && codebuf.toString().equals("")){
				decoded.append(returnKey(elt + ""));
			} else {			
				codebuf.append(elt + "");
			} 
			
			//Adds the codebuf to the final decoded string if it's in the valueSet
			if(valueSet.contains(codebuf.toString())){
				decoded.append(returnKey(codebuf.toString()));
				codebuf.delete(0, codebuf.length());
			} 
			
			if(codePos == len - 1 && !valueSet.contains(codebuf.toString()) && !codebuf.toString().equals("")
					&& !valueSet.contains(codedString)){
				throw new IllegalArgumentException();
			}			
			codePos++;
		}
		return decoded.toString();
	}
	
	//Returns the character key, given the integer (String) value
	//We can do this because we have a one to one relationship
	public char returnKey(String str){
		for(char elt : codemap.keySet()){
			elt = Character.toLowerCase(elt);
			if(codemap.get(elt).equals(str)){
				return elt;
			}
		}
		return ' ';
	}

}
