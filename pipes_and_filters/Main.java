package pipes_and_filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		
		// Initiation of the various Filters used
		InputReader reader = new InputReader();
		CircularShift shifter = new CircularShift();
		Alphabetizer alphabetizer = new Alphabetizer();
		
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> ignore = new ArrayList<String>();
		
		try {
			input = reader.read("input.txt");
			ignore = reader.read("ignore.txt");
			
			for (int i = 0; i < input.size(); i++) {
				input.set(i, alphabetizer.alphabetize(ignore, input.get(i)));
			}
			
			ArrayList<String> shiftedLines =  shifter.shift(ignore, input);
			
			Collections.sort(shiftedLines);
			
			for (int i = 0; i < shiftedLines.size(); i++) {
				System.out.println(shiftedLines.get(i));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
