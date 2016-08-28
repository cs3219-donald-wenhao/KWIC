package Implicit_Invocation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InputReader {
	//**Attributes
	//list of words to ignore
	private Queue<String> ignore	= new LinkedList<String>();
	
	//list of input lines
	private ArrayList<String> inputList = new ArrayList<String>();
	
	//list of lines ready for output
	ArrayList<String> sortedReady = new ArrayList<String>();
	
	//**Methods
	//read ignore file and stores each word in Queue ignore
	void readIgnore(String fileName) throws IOException {
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
	
	//reads input file and stores each line in ArrayList input
	void readText(String fileName) throws IOException {
		FileReader fin = new FileReader(fileName);
		BufferedReader bin = new BufferedReader(fin);
		
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
	ArrayList<String> produceOutput(){
		CircularShift cShift = new CircularShift(this.ignore);
		for(int i=0; i<this.inputList.size();i++){
			this.sortedReady = cShift.runCShift(this.inputList.get(i), this.sortedReady);
		}
		return this.sortedReady;
	}
}
