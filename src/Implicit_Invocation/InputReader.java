package Implicit_Invocation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InputReader {
	
	//list of words to ignore
	public Queue<String> ignore	= new LinkedList<String>();
	
	//list of input lines
	public ArrayList<String> inputList = new ArrayList<String>();
	
	//list of lines ready for output
	public ArrayList<String> sortedReady = new ArrayList<String>();
	
	//read ignore file and stores each word in array ignore
	public void readIgnore(String fileName) throws IOException {
		FileReader fin = new FileReader(fileName);
		BufferedReader bin = new BufferedReader(fin);
		
		String line;
		
		while( (line = bin.readLine()) != null) {
			if (line.length() == 0) {
				// reach a new line => end of input
				break;
			} else {
				this.ignore.offer(line);
			}
		}
		
		fin.close();
		bin.close();
	}
	
	//reads input file and stores each word in ArrayList input
	public void readText(String fileName) throws IOException {
		FileReader fin = new FileReader(fileName);
		BufferedReader bin = new BufferedReader(fin);
		
		inputList = new ArrayList<String>();
		String line;
		while( (line = bin.readLine()) != null) {
			if (line.length() == 0) {
				// reach a new line => end of input
				break;
			} else {
				this.inputList.add(line);
			}
		}
		
		fin.close();
		bin.close();
	}
	
	//activate to fill up ArrayList sortedReady
	public ArrayList<String> activate(){
		
	}
}
