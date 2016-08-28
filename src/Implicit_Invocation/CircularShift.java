package Implicit_Invocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//shifts each line n number of times based of number of key words and
//send each shifter line to alphabetizer
public class CircularShift {
	private Queue<String> ignore;
	private boolean[] keywordPos;
	
	CircularShift(Queue<String> ignore){
		this.ignore = ignore;
	}
	
	//returns an ArrayList of all shifted keyword headings of that input line
	ArrayList<String> runCShift(String oneLine, ArrayList<String> sortedList){
		numKeywords(oneLine);
		Alphabetize sort = new Alphabetize();
		//loop through all words of that line and store the line in the new arraylist
		for(int i=0;i<keywordPos.length;i++){
			if(keywordPos[i]){
				//add new line into arraylist
				sortedList.add(oneLine);
				//sort arraylist
				sortedList = sort.runAlpha(sortedList);
			}
			oneLine = shift(oneLine);
		}
		return sortedList;
	}
	
	//shifts the word position by one in the line
	private String shift(String line){
		StringTokenizer tokenizer = new StringTokenizer(line);
		String first = tokenizer.nextToken();
		String newLine = "";
		while(tokenizer.hasMoreTokens()){
			newLine = newLine + tokenizer.nextToken() + " "; 
		}
		line = newLine + first;
		return line;
	}
	
	//fills up keywordPos with a list of positions of the keywords
	private void numKeywords(String line){
		int count = 0;
		StringTokenizer tokenizer = new StringTokenizer(line);
		this.keywordPos = new boolean[tokenizer.countTokens()];
		Arrays.fill(keywordPos, Boolean.FALSE);
		while(tokenizer.hasMoreTokens()){
			String nextToken = tokenizer.nextToken();
			if(isKeyword(this.ignore, nextToken)){
				keywordPos[count] = true;
			}
			count++;
		}
	}
	
	//check word is a keyword
	private boolean isKeyword(Queue<String> ignore, String word){
		Boolean keyword = true;
		Queue<String> Q = new LinkedList<String>(ignore);
		while(!Q.isEmpty()){
			if(Q.poll().toUpperCase().equals(word.toUpperCase())){
				keyword = false;
			}
		}
		return keyword;
	}
	
}
