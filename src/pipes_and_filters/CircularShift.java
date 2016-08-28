package pipes_and_filters;

import java.io.EOFException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CircularShift extends Filter{
	
	
	/**
	 * Method to tokenize String according to space.
	 * 
	 * @param keyword
	 * @return Queue of String tokens
	 */
	private static Queue<String> tokenize(String input) {

		StringTokenizer tokenizer = new StringTokenizer(input);
		Queue<String> strTokens = new LinkedList<String>();

		// Tokenizes the search String taken in
		while (tokenizer.hasMoreTokens()) {
			strTokens.add(tokenizer.nextToken());
		}
		
		return strTokens;
	}
	
	/**
	 * Method to concatenate the tokens back to a string.
	 * 
	 * @param tokens
	 * @return
	 */
	private static String concatenateTokens(Queue<String> tokens) {
		
		String result = "";
		
		for (int i = 0; i < tokens.size(); i++) {
			String toAdd = tokens.remove();
			//System.out.println("TO ADD: " + toAdd);
			result += " " + toAdd;
			tokens.add(toAdd);
		}
		
		return result.trim();
		
	}

	/**
	 * Method to run this filter. Reads from pipe, do circular shifting, and writes to the next pipe.
	 */
	public void run() {
		
		while (true) {
			
			try {
				String input = read();
				Queue<String> tokens = tokenize(input);
				for (int i = 0; i < tokens.size(); i++) {
					String toAdd = tokens.remove();
					tokens.add(toAdd);
					
					if (!Arrays.asList(ignoreList).contains(tokens.peek())) {
						write(concatenateTokens(tokens));
					}
				}
				
			} catch (EOFException e) {
				out.close();
				break;
			}
		}

		
	}
	
}
