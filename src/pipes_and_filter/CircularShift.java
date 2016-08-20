package pipes_and_filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CircularShift {
	
	public CircularShift() {
		
	}
	
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
	
	private static ArrayList<String> shiftOneLine(ArrayList<String> ignoreList, Queue<String> tokens) {
		
		ArrayList<String> shiftedLines = new ArrayList<String>();
		
		for (int i = 0; i < tokens.size(); i++) {
			String toAdd = tokens.remove();
			tokens.add(toAdd);
			
			if (!ignoreList.contains(tokens.peek())) {
				shiftedLines.add(concatenateTokens(tokens));
			}
		}
		
		return shiftedLines;
	}
	
	/**
	 * Method to shift the first words to the back
	 * 
	 * @param 
	 */
	public ArrayList<String> shift(ArrayList<String> ignoreList, ArrayList<String> input) {
		
		ArrayList<String> shiftedLines = new ArrayList<String>();
		
		for (int i = 0; i < input.size(); i++) {
			String currentLine = input.get(i);
			Queue<String> tokens = tokenize(currentLine); 
			ArrayList<String> shiftedCurentLine = shiftOneLine(ignoreList, tokens);
			shiftedLines.addAll(shiftedCurentLine);	
		}
		
		return shiftedLines;
	}
	
}
