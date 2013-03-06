import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



/**
 * A class that is able to create blank code-books and develop a Huffman
 * encoding for a given code-book.
 * @author CIS-121 Staff
 * @version 3.0 - 10/15/12
 */
public class HuffmanBuilder
{

	/**
	 * This method receives as input a FreqMapI containing an alphabet
	 * and the respective frequencies of each character. It returns a new
	 * {@link CodeBookI}, where each symbol from the input freqmap now has an
	 * appropriate Huffman encoding.
	 * @param freqmap The given Frequency Map.
	 * @return A code-book with Huffman encodings.
	 */
	public static CodeBookI buildHuffmanCode(FreqMapI freqmap) 
	{
		BinaryMinHeap<Node> binNode = new BinaryMinHeap<Node>(Node.class);
		Set<Character> alpha = new HashSet<Character>();
		
		alpha = freqmap.getAlphabet();	
		for(char elt: alpha){
			binNode.insert(new Node(elt + "", freqmap.getFrequency(elt), null, null));
		}
		
		StringBuffer charList = new StringBuffer();
		Node n1;
		Node n2;
		Node n3 = new Node("", 0, null, null);
		Node check;
		
		int freqSum = 0;		
		while(!binNode.isEmpty()){		
			check = binNode.removeMin();
			if(binNode.isEmpty()){
				break;
			} else {
				binNode.insert(check);
			}
			
			//Remove the two nodes of highest priority (lowest value)
			n1 = binNode.removeMin();
			n2 = binNode.removeMin();
			
			//Creating n3's keys and values
			freqSum = n1.y + n2.y;	
			charList.append(n1.str);
			charList.append(n2.str);
			
			//Create a new internal node whose leaves are the least frequency nodes
			n3 = new Node(n1.str.toString() + n2.str.toString(), freqSum, n1, n2);
			
			//Reinsert new node n3 into the queue
			binNode.insert(n3);
		}
		
		HashMap<Character, String> codeMap = new HashMap<Character, String>();
		StringBuffer strEnc = new StringBuffer();
		
		Node temp = n3;
		for(char alph: alpha){	
			n3 = temp;
			while(n3 != null){
				if(n3.left.str.toString().equals(alph + "")){
					strEnc.append("0");
					codeMap.put(alph, strEnc.toString());
					strEnc.delete(0, strEnc.length());
					break;
				} else if(n3.right.str.toString().equals(alph + "")){
					strEnc.append("1");
					codeMap.put(alph, strEnc.toString());
					strEnc.delete(0, strEnc.length());
					break;
				} else if(n3.left.str.indexOf(alph + "") != -1){
					strEnc.append("0");
					n3 = n3.left;
				} else if(n3.right.str.indexOf(alph + "") != -1){
					strEnc.append("1");
					n3 = n3.right;
				}
			}
		}
		return new CodeBook(codeMap);
	}
}
	
class Node implements Comparable<Node>{
	public StringBuffer str = new StringBuffer();
	public int y = 0;
	public Node left;
	public Node right;
	
	//Creates a tuple with the character and the frequency value
	public Node(String x, int y, Node lt, Node rh){
		this.left = lt;
		this.right = rh;
		this.str = str.append(x);
		this.y = y;
	}
		
	//Here, "y" will be the frequency
	@Override
	public int compareTo(Node node) {
		if(this.y > node.y){
			return 1;
		} else if (this.y < node.y){
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString(){				
		return y + " " + "{" + str.toString() + "}";
		
	}
	
}